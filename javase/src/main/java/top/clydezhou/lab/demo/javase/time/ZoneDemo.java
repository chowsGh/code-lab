package top.clydezhou.lab.demo.javase.time;

import sun.util.calendar.ZoneInfo;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author clyde
 * @date 2020-06-14 15:53
 */
public class ZoneDemo {
    public static void main(String[] args) {
        LocalDateTime d = null;
        ZonedDateTime date = ZonedDateTime.now();
        System.out.println(date);
        date = ZonedDateTime.now(ZoneId.of("GMT+8"));
        System.out.println(date);
        Instant i = date.toInstant();
        System.out.println(i);
        System.out.println(ZoneId.systemDefault());
    }
}
