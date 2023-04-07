package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.Exercise2.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise2Test {

    private final String address = "Billy, Bob, 1234 Big St., Big City, California, 90210 | Joe,Smith,5678 Little St.,Little City, New York, 20109";

    @Test
    public void canGetName(){
        assertEquals("Billy", Exercise2.getName(address));
    }

    @Test
    public void canGetSurname(){
        assertEquals("Bob", Exercise2.getSurname(address));
    }

    @Test
    public void canGetStreet(){
        assertEquals("1234 Big St.", getStreet(address));
    }

    @Test
    public void canGetCity(){
        assertEquals("Big City", getCity(address));
    }

    @Test
    public void canGetState(){
        assertEquals("California", getState(address));
    }

    @Test
    public void canGetZipCode(){
        assertEquals("90210", getZipCode(address));
    }

    @Test
    public void canAddPersonCheckName(){
        boolean condition = addPerson(address).getName().equals(getName(address));
        assertTrue(condition);
    }

    @Test
    public void canAddPersonCheckInstanceOf(){
        boolean condition = addPerson(address) instanceof Person;
        assertTrue(condition);
    }

    @Test
    public void canGetArrayOfTwoNames(){
        List<String> array = new ArrayList<>();
        array.add("Billy");
        array.add("Joe");
        System.out.println("array: "+getTwoNames(address));
        assertEquals(array, getTwoNames(address));
    }

}
