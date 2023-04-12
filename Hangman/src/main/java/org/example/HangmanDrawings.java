package org.example;

import java.util.ArrayList;
import java.util.List;

public class HangmanDrawings {

    /**
     * I used ChatGPT to get these drawings, the rest of the code I wrote myself
     * @param index
     */
    public static void displayHangMan(int index){
        List<String> hangmanDrawings = new ArrayList<>();

        hangmanDrawings.add("  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========");
        hangmanDrawings.add("  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========");
        hangmanDrawings.add("  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========");
        hangmanDrawings.add("  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========");
        hangmanDrawings.add("  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========");
        hangmanDrawings.add("  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========");
        hangmanDrawings.add("  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========");

        System.out.println(hangmanDrawings.get(index));
    }
}
