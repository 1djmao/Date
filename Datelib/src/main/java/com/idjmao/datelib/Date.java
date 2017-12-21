package com.idjmao.datelib;

/**
 * Created by 1djmao on 2017/12/20.
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


//    public Date(java.sql.Time time){
//        time.getDay()
//    }

    public Date(int year, int month, int dayInMonth) {
        this.year = year;
        this.month = month;
        this.dayInMonth = dayInMonth;
        initDate();
    }

    private void initDate(){
        java.sql.Date date=new java.sql.Date(year,month,dayInMonth);
        dayInWeek=date.getDay();
        System.out.printf(""+date);

        dayInYear=0;
        for (int i = 0; i < month-1; i++) {
            dayInYear=dayInYear+dayCoutntByMonth[i];
        }
        dayInYear=dayInYear+dayInMonth;
        if (Calendar.isLeapYear(year)&&month>2){
            dayInYear++;
        }




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
