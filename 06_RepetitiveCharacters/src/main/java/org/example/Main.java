package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] myWords = sentencesWord();
        HashMap<String, Integer> myHmap = new HashMap<>();
        myHmap = WordChars(myWords);
        String my2Words = WordAndCharsCount(myHmap);
        System.out.println(my2Words);
        MixMy2Words(my2Words);
    }

    public static String[] sentencesWord() {
        System.out.print("En az iki kelimesi tekrarlı karakterler içeren bir metin giriniz : ");
        Scanner myScanner = new Scanner(System.in);
        String[] myWords = myScanner.nextLine().toLowerCase().split("\\s+");
        if (myWords.length < 2) {
            String[] args = {};
            main(args);
        }
        return myWords;
    }

    public static HashMap WordChars(String[] myWords) {
        HashMap<String, Integer> hmapWord = new HashMap<>();
        for (String myWord : myWords) {
            HashMap<Character, Integer> hmapChar = new HashMap<>();
            int aCount = 0;
            for (int i = 0; i < myWord.length(); i++) {
                if (!hmapChar.containsKey(myWord.charAt(i))) {
                    hmapChar.put(myWord.charAt(i), 1);
                } else {
                    int count = (int) hmapChar.get(myWord.charAt((i)));
                    hmapChar.put(myWord.charAt(i), count + 1);
                    aCount++;
                }
            }
            if (aCount >= 1) {
                hmapWord.put(myWord, aCount);
            }
        }
        return hmapWord;
    }

    public static String WordAndCharsCount(HashMap myHmap) {
        String my2Words = "";
        if (myHmap.size() < 2) {
            String[] args = {};
            main(args);
        }
        System.out.println("Tekrarlı karakterler içeren metin : " + myHmap.keySet().toString().replace(",", "").replace("[", "").replace("]", ""));
        TreeMap<String, Integer> sortMyHmap = new TreeMap<>(myHmap);
        try {
            my2Words = (sortMyHmap.lastKey() + " " + sortMyHmap.firstKey());
        } catch (Exception e) {
            System.err.println("Programı tekrar çalıştırınız");
        }
        return my2Words;
    }

    private static void MixMy2Words(String my2Words) {
        String vowStr = "";
        String consStr = "";
        String vowFlatStr = "aeıioöuü";
        for (int i = 0; i < my2Words.length(); i++) {
            for (int j = 0; j < vowFlatStr.length(); j++) {
                if (my2Words.charAt(i) == vowFlatStr.charAt(j)) {
                    vowStr = vowStr + my2Words.charAt(i);
                }
            }
        }
        consStr = my2Words;
        for (int i = 0; i < vowStr.length(); i++) {
            consStr = consStr.replace(Character.toString(vowStr.charAt(i)), "");
        }
        String mixSentence = Character.toString(consStr.charAt(0));
        int myLoop = (consStr.length() >= vowStr.length()) ? consStr.length() : vowStr.length();
        for (int i = 0; i < myLoop; i++) {
            if (vowStr.length() > i) {
                mixSentence += Character.toString(vowStr.charAt(i));
            }
            if (consStr.length() > i) {
                mixSentence += Character.toString(consStr.charAt(i));
            }
        }
        System.out.println(mixSentence);
    }
}