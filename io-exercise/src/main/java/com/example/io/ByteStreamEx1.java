package com.example.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.Constants.TEST_DEST_FILE;
import static com.example.Constants.TEST_SOURCE_FILE;

public class ByteStreamEx1 {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(TEST_SOURCE_FILE);
            fos = new FileOutputStream(TEST_DEST_FILE);
            int temp;
            while ((temp = fis.read()) != -1) {
                fos.write((byte) temp);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
}
