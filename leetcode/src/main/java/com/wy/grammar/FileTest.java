package com.wy.grammar;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("C:\\Program Files\\Redis");
        if (file == null || !file.exists()){
            return;
        }

        Thread t = new Thread();

    }
}
