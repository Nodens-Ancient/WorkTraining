package com.company.utils;

import java.util.UUID;

public class StringGeneratorUtil {
    public static String GetRandomString(){
        return UUID.randomUUID().toString();
    }
}
