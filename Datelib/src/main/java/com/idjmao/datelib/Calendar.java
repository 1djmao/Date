package com.idjmao.datelib;

/**
 * Created by 1djmao on 2017/12/20.
 */

public class Calendar {

    public static Date[] getWeekDays(int year,int weekInYear){
        return null;
    }

    public static Date[] getWeekDays(int year,int month,int weekInMonth){
        return null;
    }

    public static Date[] getMonthDays(int year,int month){
        return null;
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

}
