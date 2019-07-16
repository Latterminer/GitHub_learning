package com.wy.jvm;

/**
 * @author wy
 * @date 2019-07-15
 * @description
 */
import java.util.Calendar;

public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private final int beltSize;

    private static final int CURRENT_YEAR =
            Calendar.getInstance().get(Calendar.YEAR);

    private Elvis() {
        beltSize = CURRENT_YEAR - 1930;
    }

    public int beltSize() {
        return beltSize;
    }

    public static void main(String[] args) {
        System.out.println("Elvis wears size " +
                INSTANCE.beltSize() + " belt.");
    }
}
