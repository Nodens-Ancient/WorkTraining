package com.company.utils;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BinaryFileGeneratorUtil {

    public static void SetBinaryFileValuesFromList(String fileName, ArrayList<Integer> list){
        byte[] b  = new byte[list.size()];
        int currentPosition = 0;
        for (Integer i:
             list) {
            b[currentPosition] = i.byteValue();
            currentPosition++;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(b);
            fileOutputStream.close();
        }
        catch (FileNotFoundException exception) {
            System.out.println("File was not found!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
