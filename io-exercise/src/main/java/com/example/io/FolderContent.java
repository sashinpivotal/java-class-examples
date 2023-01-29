package com.example.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FolderContent {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter directory path:");
        String dirpath = br.readLine();
        System.out.println("Enter directory name");
        String dname = br.readLine();

        File file = new File(dirpath, dname);
        if (file.exists()) {
            String[] list = file.list();
            int n = list.length;
            for (int i = 0; i < n; i++) {
                System.out.println(list[i]);
                File f1 = new File(list[i]);
                if (f1.isFile()) {
                    System.out.println(": is a file");
                }
            }
            System.out.println("Number of entries in this directory " + n);
        } else {
            System.out.println("Directory not found");
        }
    }
}
