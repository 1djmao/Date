package com.idjmao.datelib;

import java.text.DecimalFormat;

import static com.idjmao.datelib.Calendar.getDayCountByMonth;

/**
 * Created by 1djmao on 2017/12/20.
 *
 * 注意：
 * 1. 以 周一 为一周的开始,周日 dayInWeek=7;
 * 2. 月份从 1 开始，即 1 表示一月份
 *
 *
 */

public class Date {

    private int year;
    private int month;
    private int dayInWeek;
    private int dayInMonth;
    private int dayInYear;

    private int weekInMonth;
    private int weekInYear;


    public Date(int year, int month, int dayInMonth) {
        this.year = year;
        this.month = month;
        this.dayInMonth = dayInMonth;
        initDate();
    }

    public Date(int year,int dayInYear){
        this.year = year;
        month = 0;

        int n=dayInYear;
        for (int i = 1; i < 12; i++) {
            if (n<getDayCountByMonth(year,i)){
                break;
            }
            n=n-getDayCountByMonth(year,i);
            month=i;
        }

        month++;
        dayInMonth=n;

        initDate();
    }

    public static Date getToday(){
        return Time.getNowTime().mDate;
    }

    private void initDate(){
        java.sql.Date date=new java.sql.Date(year-1900,month-1,dayInMonth);
        dayInWeek=date.getDay();
        if (dayInWeek==0){
            dayInWeek=7;
        }

        dayInYear=0;
        for (int i = 1; i < month; i++) {
            dayInYear=dayInYear+getDayCountByMonth(year,i);
        }
        dayInYear=dayInYear+dayInMonth;

        weekInYear=(dayInYear-dayInWeek+7)/7+1;
        weekInMonth=(dayInMonth-dayInWeek+7)/7+1;
    }

    @Override
    public String toString() {
        String s="Date:{";
        s=s+" year: "+year;
        s=s+"; month: "+month;
        s=s+"; dayInMonth: "+dayInMonth;
        s=s+"; dayInWeek: "+dayInWeek;
        s=s+"; dayInYear: "+dayInYear;
        s=s+"; weekInMonth: "+weekInMonth;
        s=s+"; weekInYear: "+weekInYear+" }";
        return s;
    }

    public String formatOut(){
        DecimalFormat format=new DecimalFormat("00");
        return year+"-"+format.format(month)+"-"+format.format(dayInMonth);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDayInWeek() {
        return dayInWeek;
    }

    public int getDayInMonth() {
        return dayInMonth;
    }

    public int getDayInYear() {
        return dayInYear;
    }

    public int getWeekInMonth() {
        return weekInMonth;
    }

    public int getWeekInYear() {
        return weekInYear;
    }
}
