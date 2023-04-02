package org.aztech.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation(){
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum);
        assertEquals("You got it", message);
    }

    @Test
    public void testOneWrongNegGuessSituation(){
        String message = game.guess(-5);
        assertEquals("Game over", message);
    }

    @Test
    public void testOneWrongPosGuessSituation(){
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum+1);
        assertEquals("Game over", message);
    }

    @RepeatedTest(10)
    public void testRandomNumberGeneration(){
        int[] rndNumCount = new int[11];
        for (int counter=0; counter<60; counter++){
            GuessingGame gameLocal = new GuessingGame();
            int randomNum = gameLocal.getRandomNumber();
            rndNumCount[randomNum] = 1;
        }

        int sum = 0;
        for (int counter =0; counter<11; counter++) {
            sum+=rndNumCount[counter];
        }
        System.out.println(sum);
        assertEquals(10, sum);
    }
}
