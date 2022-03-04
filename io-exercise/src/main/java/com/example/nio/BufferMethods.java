package com.example.nio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.example.Constants.TEST_SOURCE_FILE;

public class BufferMethods {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(TEST_SOURCE_FILE);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        char[] chars = new char[21];

        if (bufferedReader.markSupported()) {
            System.out.println("mark() method is supported");
            bufferedReader.mark(100);
        }

        bufferedReader.skip(8);

        if (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
            bufferedReader.read(chars);
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();

            bufferedReader.reset();
            for (int i = 0; i < 8; i++) {
                System.out.println((char)bufferedReader.read());
            }
        }
        bufferedReader.close();
    }
}
