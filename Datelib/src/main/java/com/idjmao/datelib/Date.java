package com.idjmao.datelib;

import java.text.DecimalFormat;

import static com.idjmao.datelib.Calendar.getDayCountByMonth;
import static com.idjmao.datelib.Calendar.getDayInWeekByDay;

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
        dayInWeek=getDayInWeekByDay(year,month,dayInMonth);

        dayInYear=0;
        for (int i = 1; i < month; i++) {
            dayInYear=dayInYear+getDayCountByMonth(year,i);
        }
        dayInYear=dayInYear+dayInMonth;

        int firstDay=getDayInWeekByDay(year,1,1);
        weekInYear=(dayInYear+firstDay-2)/7+1;

        firstDay=getDayInWeekByDay(year,month,1);
        weekInMonth=(dayInMonth+firstDay-2)/7+1;
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

    /**
     * 根据自定义格式输出字符串，如 "y-m-d 周w"输出 "2017-01-02 周一"
     * 除年份外，其余数字都是 2 位
     * y 表示 年
     * m 表示 月
     * d 表示 日
     * w 表示 星期
     * @param format
     * @return
     */
    public String formatOut(String format){
        String s=format;
        if (s.contains("y")){
            s=s.replaceFirst("y",year+"");
            s=s.replaceAll("y","");
        }
        if (s.contains("m")){
            s=s.replaceFirst("m",formatLength(month+""));
            s=s.replaceAll("m","");
        }
        if (s.contains("d")){
            s=s.replaceFirst("d",formatLength(dayInMonth+""));
            s=s.replaceAll("d","");
        }
        if (s.contains("w")){
            s=s.replaceFirst("w",getWeekNum(dayInWeek));
            s=s.replaceAll("w","");
        }
        return s;
    }
    private String formatLength(String s){
        if (s.length()<2){
            s="0"+s;
        }
        return s;
    }

    public static Date formatFrom(String date,String format){
        // TODO: 2018/1/2 格式化的字符串构造
        return null;
    }

    private String getWeekNum(int i){
        switch (i){
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "日";
        }
        return "";
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
