package com.example.io;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.example.Constants.TEST_SOURCE_DIR;

public class ListOfFileNames {
    public static void main(String[] args) {
        File file = new File(TEST_SOURCE_DIR);
        String[] list = file.list();
        for (String name : list) {
            System.out.println(name);
        }

        // Use Stream instead
        List<String> listOfFiles = Arrays.asList(list);
        listOfFiles.stream().forEach(
                fileName -> System.out.println(fileName)
        );
    }
}
