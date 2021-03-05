package com.company.UI;

import com.sun.java.accessibility.util.Translator;

import java.util.Locale;

public class Greeter {

    public void SayHello(Locale locale){
        switch (locale.getLanguage()){
            case ("rus"):
                System.out.println("Привет");
                break;
            case ("eng"):
                System.out.println("Hello");
                break;
            case ("bel"):
                System.out.println("Прывiтанне");
                break;
            default:
                System.out.println("Hello");
        }
    }
}
