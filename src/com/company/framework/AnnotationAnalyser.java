package com.company.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationAnalyser {
    public static void Analyse(Method method){
        if (method.isAnnotationPresent(Transaction.class)){
            try {
                System.out.println("Transaction started");
                method.invoke(null);//only for static methods
                System.out.println("Transaction finished");
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
