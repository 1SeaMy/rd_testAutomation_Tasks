package org.example;

public class Tests {
    public static void main(String[] args) {
        ExceptionHandler.testMethod(0, null, null, "arithmeticError");
        ExceptionHandler.testMethod(2, new int[]{1, 2, 3}, null, "arrayIndexError");
        ExceptionHandler.testMethod(0, null, null, "nullPointerError");
        ExceptionHandler.testMethod(0, null, "abc", "numberFormatError");
        ExceptionHandler.testMethod(2, null, null, "invalidOperation");
    }
}
