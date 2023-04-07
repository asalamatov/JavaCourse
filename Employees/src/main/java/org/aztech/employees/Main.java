package org.aztech.employees;

import java.text.NumberFormat;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        String people = """
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmerzzz, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
            """;

        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(people);

//        Programmer coder = new Programmer("");
//        coder.cook("Hamburger");

        int totalSalaries =0;
        IEmployee employee = null;
        while (peopleMat.find()) {
            employee = Employee.createEmployee(peopleMat.group());
            if (employee instanceof Programmer){
                System.out.println(((Programmer) employee).getIq());
            } else if (employee.getClass().equals(Manager.class)) {

            }else if (employee instanceof Analyst) {

            } else if (employee.getClass().equals(CEO.class)){

            } else {
                System.out.println("Default output");
            }
            System.out.println(employee.toString());
            totalSalaries += employee.getSalary();
        }
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
        System.out.printf("The total payout should be %s%n", moneyFormatter.format(totalSalaries));
    }

}