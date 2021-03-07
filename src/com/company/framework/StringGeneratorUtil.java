package com.company.framework;

import java.util.UUID;

public class StringGeneratorUtil {
    public static String GetRandomString(){
        return UUID.randomUUID().toString();
    }
}
