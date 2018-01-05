package com.idjmao.datelib;

/**
 * Created by 1djmao on 2017/12/20.
 */

public class Calendar {
    /**
     * 获取某年某周的所有日期
     * @param year
     * @param weekInYear
     * @return
     */
    public static Date[] getWeekDays(int year,int weekInYear){
        Date date1=new Date(year,1,1);
        int firstDayInYear=(weekInYear*7-date1.getDayInWeek()-5);
        Date[] weekDays=new Date[7];
        for (int i = 0; i < 7; i++) {
            if (firstDayInYear+i<=0){
                weekDays[i]=new Date(year-1,12,31+firstDayInYear+i);
            }else if (firstDayInYear+i>getDayCountByYear(year)){
                weekDays[i]=new Date(year+1,1,firstDayInYear+i-getDayCountByYear(year));
            }else {
                weekDays[i]=new Date(year,firstDayInYear+i);
            }
        }
        return weekDays;
    }

    /**
     * 获取某年某月某周的所有日期
     * @param year
     * @param month
     * @param weekInMonth
     * @return
     */
    public static Date[] getWeekDays(int year,int month,int weekInMonth){
        Date date1=new Date(year,month,1);
        int firstDayInMonth=(weekInMonth*7-date1.getDayInWeek()-5);
        Date[] weekDays=new Date[7];
        for (int i = 0; i < 7; i++) {
            int day=firstDayInMonth+i;
            if (day<=0){
                if (month==1){
                    weekDays[i]=new Date(year-1,12,31+day);
                }else {
                    weekDays[i]=new Date(year,month-1,getDayCountByMonth(year,month)+day);
                }
            }else if (day>getDayCountByMonth(year,month)){
                if (month==12){
                    weekDays[i]=new Date(year+1,1,day-getDayCountByMonth(year,month));
                }else {
                    weekDays[i]=new Date(year,month+1,day-getDayCountByMonth(year,month));
                }
            }else {
                weekDays[i]=new Date(year,month,day);
            }
        }
        return weekDays;
    }

    /**
     * 获取某年某月所有日期
     * @param year
     * @param month
     * @return
     */
    public static Date[] getMonthDays(int year,int month){
        Date[] dates=new Date[getDayCountByMonth(year,month)];
        for (int i = 0; i < dates.length; i++) {
            dates[i]=new Date(year,month,i+1);
        }
        return dates;
    }

    /**
     * 获取某天的前一天
     * @param date
     * @return
     */
    public static Date getLastDate(Date date){
        if (date.getMonth()==1&&date.getDayInMonth()==1){
            return new Date(date.getYear()-1,12,31);
        }else {
            return new Date(date.getYear(),date.getDayInYear()-1);
        }
    }

    /**
     * 获取某天的后一天
     * @param date
     * @return
     */
    public static Date getNextDate(Date date){
        if (date.getMonth()==12&&date.getDayInMonth()==31){
            return new Date(date.getYear()+1,1,1);
        }else {
            return new Date(date.getYear(),date.getDayInYear()+1);
        }
    }

    /**
     * 比较两个日期的大小
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDate(Date date1,Date date2){
        int n=date1.getDayInYear()-date2.getDayInYear();

        if (date1.getYear()>date2.getYear()){
            for (int i = date2.getYear(); i < date1.getYear(); i++) {
                n=n+Calendar.getDayCountByYear(i);
            }
        }else {
            for (int i = date1.getYear(); i < date2.getYear(); i++) {
                n=n-Calendar.getDayCountByYear(i);
            }
        }

        return n;
    }

    /**
     * 是否是闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year){
        if (year%400==0){
            return true;
        }

        if (year%4==0&&year%100!=0){
            return true;
        }

        return false;
    }

    /**
     * 获取某月的天数
     * @param year
     * @param month
     * @return
     */
    static int getDayCountByMonth(int year,int month){
        final int[] dayCoutntByMonth=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        if (Calendar.isLeapYear(year)&&month==2){
            return 29;
        }else {
            return dayCoutntByMonth[month-1];
        }
    }

    /**
     * 获取每年的天数
     * @param year
     * @return
     */
    static int getDayCountByYear(int year){
        if (isLeapYear(year)){
            return 366;
        }else {
            return 365;
        }
    }

    /**
     * 获取从1900.1.1开始的日期
     * @return
     */
    static int getDayNum(int year,int month,int dayInMonth){
        int dayNum=0;
        //年
        dayNum+=(year-1900)/4*1461;
        for (int i = year-(year-1900)%4; i < year; i++) {
            dayNum+=getDayCountByYear(i);
        }
        if (year>1903){
            dayNum--;
        }
        //月
        for (int i = 1; i < month; i++) {
            dayNum+=getDayCountByMonth(year,i);
        }
        //日
        dayNum+=dayInMonth;
        return dayNum;

    }

    /**
     * 根据年月日获取周几
     * @param year
     * @param month
     * @param dayInMonth
     * @return
     */
    static int getDayInWeekByDay(int year,int month,int dayInMonth){
        int dayInWeek=getDayNum(year,month,dayInMonth)%7;
        if (dayInWeek==0){
            dayInWeek=7;
        }
        return dayInWeek;
    }



}
