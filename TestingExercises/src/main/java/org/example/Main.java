package org.example;

public class Main {

    public static String capitalizeOneLetter(String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 0) {
                result += word.substring(i, i + 1).toUpperCase();
            } else {
                result += word.substring(i, i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}