package com.example.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static com.example.Constants.TEST_SOURCE_DOUBLE_FILE;
import static com.example.Constants.TEST_SOURCE_FILE;

public class ScannerEx2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = null;
        File readin = new File(TEST_SOURCE_DOUBLE_FILE);
        BufferedReader bufferedReader = null;
        FileReader inputStream = null;
        Double sum = 0D;
        try {
            inputStream = new FileReader(readin);
            bufferedReader = new BufferedReader(inputStream);
            s = new Scanner(bufferedReader);
            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    System.out.println(s.next());
                }
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        System.out.println("Total sum is " + sum);
    }
}
