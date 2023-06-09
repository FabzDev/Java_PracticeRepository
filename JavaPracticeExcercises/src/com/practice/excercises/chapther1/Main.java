package com.practice.excercises.chapther1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array array1 = new Array(5);
        array1.insert(1);
        array1.insert(2);
        array1.insert(3);
        array1.insert(4);
        array1.insert(5);
        //array1.removeAt(3);
        //System.out.println(array1.indexOf(40));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        Integer[] originalArray= list.toArray(new Integer[0]);
        System.out.println(list);
        System.out.println(Arrays.toString(originalArray));
        System.out.println(originalArray.length);

    }
}
