package com.example.io;

import java.io.*;

import static com.example.Constants.TEST_DEST_FILE;
import static com.example.Constants.TEST_SOURCE_FILE;

public class IOEx1 {
    public static void main(String[] args) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        File readin = new File(TEST_SOURCE_FILE);
        File writeto = new File(TEST_DEST_FILE);

        try {
            inputStream = new FileReader(readin);
            outputStream = new FileWriter(writeto);
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
