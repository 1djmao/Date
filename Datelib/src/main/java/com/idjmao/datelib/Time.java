package com.idjmao.datelib;

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

        System.out.println(date.toString());

        hour=date.getHours();
        minute=date.getMinutes();
        second=date.getSeconds();

        System.out.println(""+date.getDay());

        mDate=new Date(date.getYear()+1900,date.getMonth()+1,date.getDate());

        System.out.println(formatOut());

    }

    public static Time getNowTime(){
        return new Time(System.currentTimeMillis());
    }


    public String formatOut() {
        return mDate.formatOut()+" "+hour+":"+minute+":"+second;
    }
}
