package com.wy.grammar;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author wy
 * @date 2020/6/1
 * @description
 */
public class StringFormatTest {

    /**
     * 线程不安全，不能这么用
     */
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance();

    static {
        // 最大的小数位
        NUMBER_FORMAT.setMaximumFractionDigits(4);
        // 最小的小数位
        NUMBER_FORMAT.setMinimumFractionDigits(4);
        // 舍入方式
        NUMBER_FORMAT.setRoundingMode(RoundingMode.DOWN);
    }

    public static void main(String[] args) {
        // 小数和整数都行
        String a = "-6";
        BigDecimal value = new BigDecimal(a);
        final BigDecimal bigDecimal = value.setScale(4, RoundingMode.DOWN);
        final String s = bigDecimal.toPlainString();

        DecimalFormat decimalFormat = new DecimalFormat("");
        System.out.println(s);

    }
}
