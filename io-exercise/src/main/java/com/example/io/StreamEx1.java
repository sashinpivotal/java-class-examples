package com.example.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import static com.example.Constants.TEST_SOURCE_FILE;

public class StreamEx1 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;

        try {
            inputStream = new FileInputStream(TEST_SOURCE_FILE);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }
}
