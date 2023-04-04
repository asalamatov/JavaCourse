package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Main.capitalizeOneLetter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void canReturnString(){
        assertEquals("H", capitalizeOneLetter("H"));
    }

    @Test
    public void canCapitalizeFirstLetter(){
        assertEquals("H", capitalizeOneLetter("h"));
    }

    @Test
    public void canCapitalizeFirstAndThirdLetter(){
        assertEquals("HeL", capitalizeOneLetter("hel"));
    }

    @Test
    public void canCapitalizeEverySecondLetter(){
        assertEquals("HeLlO", capitalizeOneLetter("hello"));
    }
}
