package com.idjmao.datelib;

import java.text.DecimalFormat;

/**
 * Created by 1djmao on 2017/12/20.
 */

public class Time {
    Date mDate;
    int hour;
    int minute;
    int second;
    long timeMillis;



    public Time(long timeMillis) {

        int dayNum= (int) (timeMillis/86400000);

        this.timeMillis = timeMillis;

        java.util.Date date=new java.util.Date(timeMillis);

        initTime(date);
    }
    private void initTime(java.util.Date date){

        hour=date.getHours();
        minute=date.getMinutes();
        second=date.getSeconds();

        mDate=new Date(date.getYear()+1900,date.getMonth()+1,date.getDate());


    }

    public static Time getNowTime(){
        return new Time(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        String s="Time:{ ";
        s=s+mDate.toString();
        s=s+"; hour: "+hour;
        s=s+"; minute: "+minute;
        s=s+"; second: "+second;
        s=s+"; timeMillis: "+timeMillis;
        return s;
    }

    public String formatOut() {
        DecimalFormat format=new DecimalFormat("00");
        return mDate.formatOut()+" "+format.format(hour)+":"+format.format(minute)+":"+format.format(second);
    }
    /**
     * 根据自定义格式输出字符串，如 "y-m-d 周w"输出 "2017-01-02 周一"
     * 日期是小写，时间是大写
     * y 表示 年
     * m 表示 月
     * d 表示 日
     * w 表示 星期
     * H 表示 时
     * M 表示分
     * S 表示秒
     * @param format
     * @return
     */
    public String formatOut(String format){

        return null;
    }
}
