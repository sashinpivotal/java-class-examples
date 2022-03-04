package com.example.io;

import java.io.File;
import static com.example.Constants.TEST_SOURCE_DIR;

public class ListOfFileWithSpecificExtension {

    public static void main(String[] args) {
        File file = new File(TEST_SOURCE_DIR);
        String[] list = file.list();

        for (String f : list) {
            if (f.toLowerCase().endsWith(".txt")) {
                System.out.println(f);
            }
        }
    }
}
