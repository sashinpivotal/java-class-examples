package com.example.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.example.Constants.TEST_SOURCE_FILE;

public class NIOEx2 {
    public static void main(String[] args) {
        Path file = null;
        BufferedReader bufferedReader = null;
        try {
            file = Paths.get(TEST_SOURCE_FILE);
            InputStream inputStream = Files.newInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("Reading the first line of test.txt file: " +
                    bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
