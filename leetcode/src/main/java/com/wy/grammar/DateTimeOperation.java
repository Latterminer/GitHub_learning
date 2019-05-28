package com.wy.grammar;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author wangyong
 * @description java8中LocalDateTime 和 LocalDate 的运算
 * @date 2019-04-01
 */
public class DateTimeOperation {
    /**
     *
     * @param date1
     * @param date2
     * @return 如果date1小于date2，则输出-1， 相等 0，大于1
     */
    public static int compare(LocalDate date1, LocalDate date2){
        int result = date1.compareTo(date2);
        return result;
    }

    /**
     * 计算两个日期之前相隔的天数，可以更改 ChronoUnit.DAYS 来换成其他的单位
     * @param date1
     * @param date2
     * @return
     */
    public static Long getInterval(LocalDate date1, LocalDate date2){
        Long interval = date1.until(date2, ChronoUnit.DAYS);
        return interval;
    }

    /**
     * 计算两个时间戳的间隔
     * @param dateTime1
     * @param dateTime2
     * @return
     */
    public static Duration getDuration(LocalDateTime dateTime1, LocalDateTime dateTime2){
        Duration duration = Duration.between(dateTime1, dateTime2);
        return duration;
    }

    /**
     * 计算两个日期之间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static Period getPeriod(LocalDate date1, LocalDate date2){
        //返回两个日期的间隔，分为年，月，日三部分
        Period period = Period.between(date1, date2);
        //返回天那部分
        int days = period.getDays();
        //返回月那部分
        int months = period.getMonths();
        //返回年那部分
        int years = period.getYears();

        return period;
    }

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2019, 04, 01);
        LocalDate date2 = LocalDate.of(2019, 05, 01);
        LocalDate date3 = LocalDate.of(2019, 05, 01);

        //比较
        System.out.println(compare(date1, date2));
        System.out.println(compare(date2, date3));
        System.out.println(compare(date3, date1));
    }
}
