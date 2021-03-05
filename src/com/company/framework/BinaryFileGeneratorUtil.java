package com.company.framework;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BinaryFileGeneratorUtil {

    public static void SetBinaryFileValuesFromList(String fileName, ArrayList<Integer> list) throws IOException {
        byte[] b  = new byte[list.size()];
        ArrayList<Byte> b1 = new ArrayList<>();
        int currentPosition = 0;
        for (Integer i:
             list) {
            b[currentPosition] = i.byteValue();
            currentPosition++;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(b);
        fileOutputStream.close();
    }
}
