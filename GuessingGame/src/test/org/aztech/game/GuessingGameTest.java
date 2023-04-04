package org.aztech.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessingGameTest {

    public static final int GAME_RANDOMNESS_RETRIES = 100;
    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation(){
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum);
        assertEquals("You got it in 1 try", message);
    }

    @Test
    public void testOneWrongNegGuessSituation(){
        String message = game.guess(-5);
        assertEquals("Game over - you are too low", message);
    }

    @Test
    public void testOneWrongPosGuessSituation(){
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum+1);
        assertEquals("Game over - you are too high", message);
    }

//    @RepeatedTest(10)
    @Test
    public void testRandomNumberGeneration(){
        int[] rndNumCount = new int[11];
        for (int counter = 0; counter< GAME_RANDOMNESS_RETRIES; counter++){
            GuessingGame gameLocal = new GuessingGame();
            int randomNum = gameLocal.getRandomNumber();
            rndNumCount[randomNum] = 1;
        }

        int sum = 0;
        for (int counter =0; counter<11; counter++) {
            sum+=rndNumCount[counter];
        }
        assertEquals(10, sum);
    }

    @Test
    public void testFourWrongGuesses(){
        makeThreeWrongGuesses();
        String message = game.guess(-3);
        assertEquals("Game over and you've had 4 tries.", message);
    }

    private void makeThreeWrongGuesses() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
    }

    @Test
    public void testThreeWrongGuessesAndOneCorrect(){
        makeThreeWrongGuesses();
        String message = game.guess(game.getRandomNumber());
        assertEquals("You got it in 4 tries", message);

    }

    @Test
    public void testTwoWrongGuessesAndOneCorrect(){
        game.guess(-3);
        game.guess(-3);
        String message = game.guess(game.getRandomNumber());
        assertTrue(message.contains(" 3 "));
        assertTrue(message.contains("You got it"));
        assertTrue(message.contains("tries"));
    }

    @Test
    public void testTenWrongGuesses(){
        makeThreeWrongGuesses();
        makeThreeWrongGuesses();
        makeThreeWrongGuesses();
        String message = game.guess(-3);
        assertEquals("Sorry, you are limited to only 4 tries.", message);
    }

}
