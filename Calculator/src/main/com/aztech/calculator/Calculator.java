package com.aztech.calculator;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Calculator {

    public int add(int num1, int num2) {
        if (num1!=Integer.MAX_VALUE && num2!=Integer.MAX_VALUE) return num1+num2;
        else return -1;
    }

    public float divide(float num1, float num2){
        return num1/num2;
    }

    public String calcAnnuity(String R, int t, String r, int n) {
        BigDecimal a = new BigDecimal(r).divide(new BigDecimal(n));
        BigDecimal b = BigDecimal.ONE.add(a);
        BigDecimal c = b.pow(n*t);
        BigDecimal d = c.subtract(BigDecimal.ONE);
        BigDecimal e = d.divide(a);
        BigDecimal F = new BigDecimal(R).multiply(e);
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
        return moneyFormatter.format(F);
    }
}
