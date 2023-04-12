package org.aztech.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee{

    protected final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
    private static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*?)\\})?\\n";
    public static final Pattern PEOPLE_PAT = Pattern.compile(PEOPLE_REGEX);
    protected final Matcher peopleMat;
    protected String lastname;
    protected String firstname;
    protected LocalDate dob;
    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    protected Employee(){
        peopleMat = null;
        lastname = "N/A";
        firstname = "N/A";
        dob = null;
    };


    public Employee(String personText) {
        peopleMat = PEOPLE_PAT.matcher(personText);
        if (peopleMat.find()) {
            this.lastname = peopleMat.group("lastName");
            this.firstname = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob")));
        }
    }

    public static IEmployee createEmployee(String employeeText){
        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(employeeText);
        if (peopleMat.find()){
            return switch (peopleMat.group("role")){
                case "Programmer" -> new Programmer(employeeText);
                case "Manager" -> new Manager(employeeText);
                case "Analyst" -> new Analyst(employeeText);
                case "CEO" -> new CEO(employeeText);
                default -> new DummyNobody();
            };
        }else{
            return new DummyNobody();
        }
    }

    public abstract int getSalary();

    @Override
    public String toString() {
        return String.format("%s, %s: %s - %s", lastname, firstname, moneyFormatter.format(this.getSalary()), moneyFormatter.format(getBonus()));
    }

    public double getBonus(){
        return getSalary()*1.1;
    }

    private static final class DummyNobody extends Employee implements IEmployee {
        @Override
        public int getSalary() {
            return 0;
        }

    }
}
