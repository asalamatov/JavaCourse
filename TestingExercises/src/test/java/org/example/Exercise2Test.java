package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Exercise2.getName;
import static org.example.Exercise2.getSurname;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise2Test {
    @Test
    public void canGetName(){
        assertEquals("Billy", getName("Billy"));
    }

    @Test
    public void canGetSurname(){
        assertEquals("Bob", getSurname("Billy, Bob"));
    }
}
