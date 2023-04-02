package com.aztech.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    public void canAddZeroPlusZero(){
        int sum = calc.add(0, 0);
        assertEquals(0, sum, "Was expecting sum of 0");
    }

    @Test
    public void canAddOnePlusOne(){
        int sum = calc.add(1, 1);
        assertEquals(2, sum, "Was expecting sum of 2");
    }

    @Test
    public void canAddMinusOneAndMinusOne(){
        int sum = calc.add(-1, -1);
        assertEquals(-2, sum, "Was expecting sum of -2");
    }

    @Test
    public void canAddMinusFiveAndPlusTen(){
        int sum = calc.add(-5, 10);
        assertEquals(5, sum, "Was expecting sum of 5");
    }

    @Test
    @Disabled
    public void canAddMaxIntAndOne(){
        int sum = calc.add(Integer.MAX_VALUE, 1);
        System.out.println(sum); // 2147483647
        assertEquals(-1, sum);
    }

    @Test
    public void canDivideFiveByTwo(){
        float divResult = calc.divide(5,2);
        assertEquals(2.5, divResult);
    }

    @Test
    public void annuityExample(){
        String answer = calc.calcAnnuity("22000", 7, ".06", 1);
        assertEquals("$184,664.43", answer, "Annuity example one has a problem");
    }

    @Test
    public void annuityPractice2(){
        String answer = calc.calcAnnuity("1200", 10, ".08", 4);
        assertEquals("$72,482.38", answer);
    }
}
