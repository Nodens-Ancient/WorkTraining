package com.company.utils;

import java.sql.Date;
import java.sql.Time;

public class TimeRegisterUtil {
    public static float CountTimeForMethod(Runnable method){
        long time = System.currentTimeMillis();
        method.run();
        return System.currentTimeMillis() - time;
    }
}
