package com.example.io;

import java.io.*;

import static com.example.Constants.TEST_DEST_FILE;
import static com.example.Constants.TEST_SOURCE_FILE;

public class IOEx2 {
    public static void main(String[] args) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;
        BufferedReader bufferedReader = null;
        PrintWriter  printWriter = null;
        File readin = new File(TEST_SOURCE_FILE);
        File writeto = new File(TEST_DEST_FILE);

        try {
            inputStream = new FileReader(readin);
            outputStream = new FileWriter(writeto);
            bufferedReader = new BufferedReader(inputStream);
            printWriter = new PrintWriter(outputStream);
            String l;
            while ((l = bufferedReader.readLine()) != null) {
                printWriter.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }

        }
    }
}
