package com.company.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {

    public static ArrayList<Integer> GetListOfValuesFromBinaryFile(String fileName) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] allBytes = fileInputStream.readAllBytes();
            for (int i = 0; i < allBytes.length; i++) {
                Integer a = (int) allBytes[i];
                list.add(a);
            }
            fileInputStream.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File was not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<String> GetFilesList(String path){
        ArrayList<String> list = new ArrayList<>();
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            list.add(files[i].getName());
        }
        return list;
    }
}
