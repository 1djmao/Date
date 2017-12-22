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
}
