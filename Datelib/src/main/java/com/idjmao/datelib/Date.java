package com.idjmao.datelib;

/**
 * Created by 1djmao on 2017/12/20.
 *
 * 注意：以 周一 为一周的开始
 *
 */

public class Date {

    private int[] dayCoutntByMonth=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

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

    private void initDate(){
        java.sql.Date date=new java.sql.Date(year-1900,month-1,dayInMonth);
        dayInWeek=date.getDay();

        dayInYear=0;
        for (int i = 0; i < month-1; i++) {
            dayInYear=dayInYear+dayCoutntByMonth[i];
        }
        dayInYear=dayInYear+dayInMonth;
        if (Calendar.isLeapYear(year)&&month>2){
            dayInYear++;
        }

        int a=dayInWeek;
        if (a==0){
            a=7;
        }

//        if (a<=7){
//            weekInYear=1;
//        }else {
//        }
        weekInYear=(dayInYear-a+7)/7+1;




    }

    public static Date getToday(){
        return Time.getNowTime().mDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String formatOut(){
        return year+"-"+month+"-"+dayInMonth;
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
