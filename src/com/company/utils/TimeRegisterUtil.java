package com.company.utils;

public class TimeRegisterUtil {
    public static float CountTimeForMethod(Runnable method){
        long time = System.currentTimeMillis();
        method.run();
        return System.currentTimeMillis() - time;
    }
}
