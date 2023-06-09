package com.practice.excercises.chapther1;

public class Array {

    private int[] array;
    private int pointer = 0;

    public Array(int lenght) {
        this.array = new int[lenght];
    }

    public void print() {
        for (int cell : array) {
            System.out.print(cell + ", ");
        }
    }

    public void printPointer() {
        System.out.print("Pointer: " + pointer);
    }

    public void insert(int value) {
        if ((pointer + 1) > array.length) {
            int[] tempArray = new int[pointer + 1];
            for (int i = 0; i < pointer; i++) {
                tempArray[i] = array[i];
            }
            array = new int[pointer + 1];
            for (int i = 0; i < pointer; i++) {
                array[i] = tempArray[i];
            }
            array[pointer] = value;
        } else {
            array[pointer] = value;
        }
        pointer++;
    }

    public void removeAt(int at) {
        if (at + 1 == array.length) { // array {1,2.3,4,5}, pointer= 5 (next 5)
            int[] tempArray = new int[pointer - 1]; //
            for (int i = 0; i < pointer - 1; i++) {
                tempArray[i] = array[i];
            }
            array = new int[pointer - 1];
            for (int i = 0; i < pointer - 1; i++) {
                array[i] = tempArray[i];
            }
        } else {
            int[] tempArray = new int[pointer];
            for (int i = 0; i < pointer; i++) {
                tempArray[i] = array[i];
            }
            array = new int[pointer - 1];
            for (int i = 0; i < at; i++) {
                array[i] = tempArray[i];
            }
            for (int i = at; i < array.length; i++) {
                array[i] = tempArray[i+1];
            }
        }
        pointer--;
    }
}
