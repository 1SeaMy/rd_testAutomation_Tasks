package org.example;

public class OperationClass {

    public static int arithmeticError(int number) {
        return 10 / number;
    }

    public static int arrayIndexError(int[] array) {
        return array[5];
    }

    public static int nullPointerError(String str) {
        return str.length();
    }

    public static int numberFormatError(String str) {
        return Integer.parseInt(str);
    }
}