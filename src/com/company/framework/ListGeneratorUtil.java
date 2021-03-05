package com.company.framework;

import java.util.ArrayList;
import java.util.Random;

public class ListGeneratorUtil {
    private final int size;

    public ListGeneratorUtil(int size) {
        this.size = size;
    }

    public ArrayList<Integer> GetListWithRandomValues(int startValue, int endValue){
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.listIterator().add(startValue +random.nextInt(endValue));
        }
        return list;
    }



}
