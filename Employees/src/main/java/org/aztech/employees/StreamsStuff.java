package org.aztech.employees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsStuff {

    public static void main(String[] args) {
        String peopleText = """
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmerzzz, {locpd=2000,yoe=10,iq=140}
            Flinstone2, Fred2, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone4, Fred4, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble2, Barney2, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble3, Barney3, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble4, Barney4, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble5, Barney5, 2/2/1905, Manager, {orgSize=300,dr=10}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flinstone2, Wilma2, 3/3/1910, Analyst, {projectCount=3}
            Flinstone3, Wilma3, 3/3/1910, Analyst, {projectCount=3}
            Flinstone4, Wilma4, 3/3/1910, Analyst, {projectCount=3}
            Flinstone5, Wilma5, 3/3/1910, Analyst, {projectCount=3}
            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
            """;

        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(peopleText);
        peopleMat.find();
Employee.createEmployee(peopleMat.group());


        peopleText.lines()
                .map(Employee::createEmployee)
                .forEach(System.out::println);

    }

}
