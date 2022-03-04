package com.example.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static com.example.Constants.TEST_SOURCE_FILE;

public class ScannerEx1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = null;
        File readin = new File(TEST_SOURCE_FILE);
        BufferedReader bufferedReader = null;
        FileReader inputStream = null;
        try {
            inputStream = new FileReader(readin);
            bufferedReader = new BufferedReader(inputStream);
            s = new Scanner(bufferedReader);
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
