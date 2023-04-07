package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.Main.capitalizeOneLetter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void canReturnString(){
        Assertions.assertEquals("H", Main.capitalizeOneLetter("H"));
    }

    @Test
    public void canCapitalizeFirstLetter(){
        Assertions.assertEquals("H", Main.capitalizeOneLetter("h"));
    }

    @Test
    public void canCapitalizeFirstAndThirdLetter(){
        Assertions.assertEquals("HeL", Main.capitalizeOneLetter("hel"));
    }

    @Test
    public void canCapitalizeEverySecondLetter(){
        Assertions.assertEquals("HeLlO", Main.capitalizeOneLetter("hello"));
    }
}
