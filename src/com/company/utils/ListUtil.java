package com.company.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListUtil {
    public static ArrayList<Integer> FilterListByValue(ArrayList<Integer> list, int targetValue){
        list.removeIf(integer -> integer < targetValue);
//        while (listIterator.hasNext()){
//            if (listIterator.next() < targetValue){
//                listIterator.remove();
//            }
//        }
        return list;
    }

    public static Integer GetMaxValue(ArrayList<Integer> list) {
        ListIterator<Integer> listIterator = list.listIterator();
        Integer max = 0;
        while (listIterator.hasNext()){
            Integer currentValue = listIterator.next();
            if (currentValue > max){
                max = currentValue;
            }
        }
        return max;
    }

    public static float GetAverageValueOfList(List<Integer> list){
        float sum = 0f;
        for (Integer i:
             list) {
            sum += i;
        }
        return sum/ list.size();
    }
}
