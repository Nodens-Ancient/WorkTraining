package com.company;


import com.company.UI.UserInterface;
import com.company.framework.BinaryFileGeneratorUtil;
import com.company.framework.Line;
import com.company.framework.ListGeneratorUtil;
import com.company.models.appliance.Philips;
import com.company.models.appliance.TeaPot;
import com.company.models.appliance.Toaster;
import com.company.utils.FileUtil;
import com.company.utils.ListUtil;
import com.company.framework.Point;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class Main {
    /*------------Task_1------------*/
    private static final int SIZE_OF_LIST = 10;
    private static final int TARGET_VALUE = 4;
    /*------------Task_3------------*/
    private static final int MAX_GRADE = 10;
    private static final int MIN_GRADE = 1;
    /*------------Task_4------------*/
    private static final String TEAPOT_NAME = "DefaultTeapot";
    private static final String PHILIPS_TEAPOT_NAME = "PhilipsTeapot";
    private static final String TOASTER_NAME = "Toaster";
    /*------------Task_5------------*/
    private static final String BINARY_FILE_NAME = "BinaryFile.txt";
    private static final int NUMBER_OF_VALUES = 20;
    private static final int MAX_VALUE = 20;
    private static final int MIN_VALUE = 1;
    /*------------Task_6------------*/
    private static final Point POINT_1 = new Point();
    private static final Point POINT_2 = new Point(3f,4f);

    private static final Point POINT_3 = new Point(3f,1f);
    private static final Point POINT_4 = new Point(2f,5f);

    private static final Point POINT_5 = new Point(2f,15f);
    /*------------Task_7------------*/
    private static final String FOLDER_NAME_PATH = "D:\\Games";
    /*------------Task_11------------*/
    private static final float MONEY_AMOUNT = 153.5f;
    /*------------Task_12------------*/
    private static final String USERS_COUNTRY = "";
    private static final String USERS_LANGUAGE = "";

    public static void main(String[] args) throws IOException {
        Task1();
        Task3();
        Task4();
        Task5();
        Task6();
        Task7();
        Task11();
        Task12();
    }

    private static void Task1(){
        System.out.println("\n------------Task_1------------");

        Line line = new Line();
        line.PrintLineInfo();

        Line secondLine = new Line(POINT_1, POINT_2);
        secondLine.PrintLineInfo();

        Line thirdLine = new Line(POINT_3, POINT_4);
        thirdLine.PrintLineInfo();

        thirdLine.PointBelongsToLine(POINT_5);
    }

    private static void Task3(){
        System.out.println("\n------------Task_3------------");
        ListGeneratorUtil listGeneratorUtil = new ListGeneratorUtil(SIZE_OF_LIST);
        ArrayList<Integer> list = listGeneratorUtil.GetListWithRandomValues(MIN_GRADE, MAX_GRADE);

        System.out.print("List with all marks: ");
        System.out.println(list);

        System.out.print("List with only positive marks: ");
        System.out.println(ListUtil.FilterListByValue(list, TARGET_VALUE));
    }

    private static void Task4(){
        System.out.println("\n------------Task_4------------");
        ListGeneratorUtil listGeneratorUtil = new ListGeneratorUtil(SIZE_OF_LIST);
        ArrayList<Integer> list = listGeneratorUtil.GetListWithRandomValues(MIN_GRADE, MAX_GRADE);

        System.out.print("List with all marks: ");
        System.out.println(list);

        System.out.print("Highest mark: ");
        System.out.println(ListUtil.GetMaxValue(list));
    }

    private static void Task5(){
        System.out.println("\n------------Task_5------------");
        Philips philips = new Philips(PHILIPS_TEAPOT_NAME);
        philips.TurnOn();

        TeaPot teaPot = new TeaPot(TEAPOT_NAME);
        teaPot.BoilWater();

        Toaster toaster = new Toaster(TOASTER_NAME);
        toaster.TurnOn();
    }

    private static void Task6() throws IOException {
        System.out.println("\n------------Task_6------------");
        ListGeneratorUtil listGeneratorUtil = new ListGeneratorUtil(NUMBER_OF_VALUES);
        ArrayList<Integer> list = listGeneratorUtil.GetListWithRandomValues(MIN_VALUE, MAX_VALUE);
        BinaryFileGeneratorUtil.SetBinaryFileValuesFromList(BINARY_FILE_NAME, list);
        System.out.printf("List of values is: %s\n",list);

        System.out.printf("List of values from binary file is: %s\n", FileUtil.GetListOfValuesFromBinaryFile(BINARY_FILE_NAME));
        System.out.printf("Average value: %s\n", ListUtil.GetAverageValueOfList(FileUtil.GetListOfValuesFromBinaryFile(BINARY_FILE_NAME)));
    }

    private static void Task7(){
        System.out.println("\n------------Task_7------------");
        try {
            System.out.println(FileUtil.GetFilesList(FOLDER_NAME_PATH));
        }
        catch (NullPointerException exception){
            System.out.printf("Path %s does not lead to a folder", FOLDER_NAME_PATH);
        }
    }

    private static void Task11(){
        System.out.println("\n------------Task_11------------");
        System.out.println(NumberFormat.getCurrencyInstance(new Locale("ru", "Ru"))
                .format(MONEY_AMOUNT));
    }

    private static void Task12(){
        Locale locale = new Locale(USERS_LANGUAGE, USERS_COUNTRY, "variant");
        UserInterface userInterface = new UserInterface();
        userInterface.greeter.SayHello(locale);
    }


}
