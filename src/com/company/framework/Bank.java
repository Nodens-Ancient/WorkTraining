package com.company.framework;

import java.lang.reflect.Method;

public class Bank {
    @Transaction
    public void FirstTransactionMethod(){
        MethodController(new Object(){}.getClass().getEnclosingMethod(), "start");
        System.out.println("First Bank Method");
        MethodController(new Object(){}.getClass().getEnclosingMethod(), "end");
    }
    @Transaction
    public void SecondTransactionMethod(){
        MethodController(new Object(){}.getClass().getEnclosingMethod(), "start");
        System.out.println("Second Bank Method");
        MethodController(new Object(){}.getClass().getEnclosingMethod(), "end");
    }

    public void ThirdTransactionMethod(){
        MethodController(new Object(){}.getClass().getEnclosingMethod(), "start");
        System.out.println("Third Bank Method");
        MethodController(new Object(){}.getClass().getEnclosingMethod(), "end");
    }

    public void MethodController(Method actionOfMethod, String state)
    {
        if(actionOfMethod.isAnnotationPresent(Transaction.class)){
            System.out.println("Transaction is " + state);
        }
    }
}

