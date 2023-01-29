package com.example.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.example.Constants.TEST_SOURCE_FILE;

public class BinaryFileReadEx1 {
    public static void main(String[] args) {

        String fileName = TEST_SOURCE_FILE;

        try {
            byte[] buffer = new byte[1000];
            FileInputStream inputStream = new FileInputStream(fileName);
            int total = 0;
            int nRead = 0;
            while ((nRead = inputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer));
                total += nRead;
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException e) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }
}
