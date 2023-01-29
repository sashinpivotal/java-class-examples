package com.example.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader
                = new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("Input your name: ");
        String name = bufferedReader.readLine();
        System.out.println("Your name is: " + name);
    }
}
