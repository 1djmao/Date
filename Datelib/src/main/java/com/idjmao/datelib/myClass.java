package com.idjmao.datelib;

public class myClass {

    public static void main(String[] args){
//        Date date=new Date(2017,1,1);
        Date date=Date.getToday();
        System.out.println("darInWeek "+date.getDayInWeek());
        System.out.println("dayInYear "+date.getDayInYear());
        System.out.printf("weekInYear "+date.getWeekInYear());

    }

}
