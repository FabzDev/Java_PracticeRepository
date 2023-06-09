package com.practice.excercises.chapther1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array array1 = new Array(5);
        array1.insert(1);
        array1.insert(2);
        array1.insert(3);
        array1.insert(4);
        array1.insert(5);
        array1.removeAt(3);
        array1.print();
    }
}
