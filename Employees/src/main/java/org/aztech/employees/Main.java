package org.aztech.employees;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String people = """
            Flinstone, Fred, 1/1/1900, Programmer
            Rubble, Barney, 2/2/1905, Manager
            Flinstone, Wilma, 3/3/1910, Analyst
            Rubble, Betty, 4/4/1915, CEO
            """;

        String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)\\n";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(people);

        int totalSalaries =0;
        while (mat.find()) {
            totalSalaries += switch (mat.group("role")){
                case "Programmer" -> 3000;
                case "Mger" -> 3500;
                case "Analyst" -> 2500;
                case "CEO" -> 5000;
                default -> 0;
            };
        }
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
        System.out.printf("The total payout should be %s%n", moneyFormatter.format(totalSalaries));


    }

}