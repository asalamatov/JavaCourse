package org.aztech.game;

import java.security.SecureRandom;

public class GuessingGame {
    private final int randomNumber = new SecureRandom().nextInt(10)+1;

    public String guess(int guessedNumber) {
        return (guessedNumber==getRandomNumber() ? "You got it" : "Game over");
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
