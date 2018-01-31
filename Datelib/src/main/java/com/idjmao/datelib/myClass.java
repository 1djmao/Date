package com.idjmao.datelib;

public class myClass {

    public static void main(String[] args){
//        Date date=new Date(2017,10,1);
////        Date date=Date.getToday();
//        Date date=new Date(2017,357);
//        System.out.println(date.formatOut());
//        System.out.println("darInWeek "+date.getDayInWeek());
//        System.out.println("dayInYear "+date.getDayInYear());
//        System.out.println("weekInYear "+date.getWeekInYear());
//        System.out.println("weekInMonth "+date.getWeekInMonth());

//        Date[] dates=Calendar.getWeekDays(2016,9,1);
//        for (Date d:dates) {
//            System.out.println(d.formatOut());
//        }

        Date date=new Date(2018,1,30);
        System.out.println(date.formatOut("yyyyyyyy**ddddgg_m+++w"));

        System.out.println(Calendar.getNextDate(date).formatOut());


        for (int i = 0; i < 100; i++) {
            System.out.println(new Date(2018,i));
        }

//        Date date1=Calendar.getLastDate(date);
//        Time time=Time.getNowTime();
//        System.out.println(date1.toString());
//        System.out.println(date1.formatOut());
//        System.out.println(time.toString());
//        System.out.println(time.formatOut());




    }

}
