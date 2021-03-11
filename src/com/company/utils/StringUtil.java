package com.company.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private String startString;
    private StringBuilder stringBuilder;
    private String testString;

    public StringUtil(){
        this.startString = "";
        this.stringBuilder = new StringBuilder();
        testString = StringGeneratorUtil.GetRandomString().replace("-","");
    }

    public StringUtil(String testString){
        this.testString = testString;
        this.startString = "";
        this.stringBuilder = new StringBuilder();
    }

    public void CompareExecutionTime(){
        System.out.printf("required time is %s MS\n", TimeRegisterUtil.CountTimeForMethod(this::StringAdder));
        System.out.printf("required time is %s MS\n", TimeRegisterUtil.CountTimeForMethod(this::StringBuilderAdder));
    }

    private void StringAdder(){
        System.out.print("Starting String test: ");
        for (int i = 0; i < 10000; i++) {
            startString += this.testString;
        }
    }

    private void StringBuilderAdder(){
        System.out.print("Starting StringBuilder test: ");
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(this.testString);
        }
    }

    public static void GetMatchesInString(Pattern pattern){
        String line = StringGeneratorUtil.GetRandomString();
        GetMatchesInString(pattern, line.toUpperCase());
    }
    public static void GetMatchesInString(Pattern pattern, String line){
        Matcher matcher = pattern.matcher(line);
        System.out.println(line);
        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }

    public static String ReplaceInString(Pattern pattern, String line, String replaceWith){
        Matcher matcher = pattern.matcher(line);
        return matcher.replaceAll(replaceWith);
    }
}
