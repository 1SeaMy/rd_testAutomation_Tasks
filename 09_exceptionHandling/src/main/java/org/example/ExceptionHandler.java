package org.example;

public class ExceptionHandler {

    public static void testMethod(int number, int[] array, String str, String operationName) {
        try {
            switch (operationName) {
                case "arithmeticError":
                    OperationClass.arithmeticError(number);
                    break;
                case "arrayIndexError":
                    OperationClass.arrayIndexError(array);
                    break;
                case "nullPointerError":
                    OperationClass.nullPointerError(str);
                    break;
                case "numberFormatError":
                    OperationClass.numberFormatError(str);
                    break;
                default:
                    System.out.println("Beklenmyen hata türü.");
            }
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
            System.out.println("Hata oluştu: " + e.getMessage());
        }
    }
}