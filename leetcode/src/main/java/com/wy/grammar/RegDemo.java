package com.wy.grammar;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wy
 * @date 2020/4/16
 * @description
 */
public class RegDemo {
    private static Pattern pattern = Pattern.compile("hqms_er_1153.*?}");
    public static void main(String[] args) {
        final Matcher matcher = pattern.matcher("hqms_er_1153:\"1\"}]},hqms_er_1153:\"1\"}]},hqms_er_1153:\"1\"}]},hqms_er_1153:\"1\"}]},hqms_er_1153:\"1\"}]},hqms_er_1153:\"1\"}]}, ");
        List<String> list = new ArrayList<>();

        while (matcher.find()) {
            list.add(matcher.group());
        }

        System.out.println(list);

    }
}
