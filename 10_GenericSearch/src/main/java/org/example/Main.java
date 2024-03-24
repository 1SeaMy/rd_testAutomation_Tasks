package org.example;
import java.util.List;
import java.util.Scanner;
public class Main <T>{
    public T searchItem(List<T> collection, T itemToFind) {
        return collection.stream()
                .filter(item -> item.equals(itemToFind))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        System.out.print("Bir koleksiyon giriniz : ");
        Scanner myScanner = new Scanner(System.in);
        String[] myWords = myScanner.nextLine().toLowerCase().split("\\s+");
        System.out.print("Koleksiyonda aranacak değeri giriniz : ");
        String myWord = myScanner.nextLine().toLowerCase();

        List<String> myList = List.of(myWords);

        Main<String> searcher = new Main<>();
        String myResult = searcher.searchItem(myList, myWord);

        if (myResult != null)
            System.out.println(myResult);
        else
            System.out.println("-1");
    }}