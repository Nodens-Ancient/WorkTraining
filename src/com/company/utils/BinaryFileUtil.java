package com.company.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BinaryFileUtil {
    public static ArrayList<Integer> GetListOfValuesFromBinaryFile(String fileName) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte[] allBytes =fileInputStream.readAllBytes();
        for (int i = 0; i < allBytes.length; i++) {
            Integer a =(int) allBytes[i];
            list.add(a);
        }
        fileInputStream.close();
        return list;
    }
}
