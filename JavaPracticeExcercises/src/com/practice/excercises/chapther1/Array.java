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
        }
        array[pointer] = value;
        pointer++;
    }

    public void removeAt(int at) { // array.length 5, pointer 5, at 2
        for (int i = at; i < pointer - 1; i++) {
            array[i] = array[i + 1];
        }
        pointer--;
        int[] tempArray = new int[pointer];
        for (int i = 0; i < pointer; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }


    public int indexOf(int value) {
        int count = 0;
        for (int item : array) {
            if (item == value)
                return count;
            count++;
        }

        return count;
    }
}
