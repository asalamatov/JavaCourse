package org.example;

public class DisplayInstructions {
    /**
     * this text is copied from internet, I did not write this text, but the code is mine
     */
    public static void showInstructions() {
        System.out.println("""
                -------Instructions-------
                1. A random word was picked.
                2. Try to guess the letters of the word and input them.
                3. You have 6 guesses. Once they run out, you lose!
                4. The amount of guesses goes down if you're wrong.
                5. Once you get all of the letters right, you win!
                """);

    }
}
