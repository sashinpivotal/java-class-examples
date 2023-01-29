package com.example.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.example.Constants.TEST_DEST_FILE;

public class BinaryFileWriteEx2 {
    public static void main(String[] args) {

        String fileName = TEST_DEST_FILE;

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Hello there, ");
            bufferedWriter.write(" here is some text. ");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file");

            bufferedWriter.close();
        } catch (IOException exception) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }
}
