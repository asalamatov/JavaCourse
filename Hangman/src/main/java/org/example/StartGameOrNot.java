package org.example;

import java.util.Scanner;

/**
 * this class is the starting user interface of the game, checks if the user wants to play or not
 */
public class StartGameOrNot {
    public static Boolean startGame() {
        System.out.print("\n\nWould you like to play hangman? (Y or N)   ");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine().toLowerCase().strip();

        if ("y".equals(answer)) {
            System.out.println("\nEnjoy!\n");
            return true;
        } else {
            System.out.println("\nBye!\n");
            return false;
        }
    }
}
