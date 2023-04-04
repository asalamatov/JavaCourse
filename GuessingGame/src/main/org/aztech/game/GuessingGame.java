package org.aztech.game;

import java.security.SecureRandom;

public class GuessingGame {
    private final int randomNumber = new SecureRandom().nextInt(10)+1;
    private int counter = 0;

    public String guess(int guessedNumber) {
        counter ++;
        String tryTries = (counter==1) ? "try" : "tries";
        String winningMessage = String.format("You got it in %d %s", counter, tryTries);
        String response = null;
        if (counter == 4 && guessedNumber!=getRandomNumber()){
            response =  String.format("Game over and you've had %d %s.",counter, tryTries);
        } else if (counter>4){
            response = "Sorry, you are limited to only 4 tries.";
        }else{
            String tooHighLowText = null;
            if (guessedNumber < getRandomNumber()){
                tooHighLowText = " - you are too low";
            } else{
                tooHighLowText = " - you are too high";
            }
            String loseText = String.format("Game over%s", tooHighLowText);
            response = (guessedNumber==getRandomNumber() ? winningMessage : loseText);
        }
        return response;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        boolean loopShouldContinue = true;
        do {
            String input = System.console().readLine("Enter a number: ");
            if ("q".equals(input)){
                return;
            }
            String output = game.guess(Integer.parseInt(input));
            if (output.contains("You got it" ) || output.contains("over")){
                loopShouldContinue = false;
            }

        } while (loopShouldContinue);
    }
}
