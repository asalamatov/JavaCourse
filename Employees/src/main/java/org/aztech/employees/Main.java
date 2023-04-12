package org.aztech.employees;

import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;

public class Main {

    private static final Map<String, Integer> salaryMap = new LinkedHashMap<>();
    private static final Set<IEmployee> employees = new TreeSet<>((e1, e2)->Integer.compare(e1.getSalary(), e2.getSalary()));

    public static void main(String[] args) {
        String people = """
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2020,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2010,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=200,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2030,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2040,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2400,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmerzzz, {locpd=4000,yoe=10,iq=140}
            Flinstone2, Fred2, 1/1/1900, Programmer, {locpd=2400,yoe=10,iq=140}
            Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=2500,yoe=10,iq=140}
            Flinstone4, Fred4, 1/1/1900, Programmer, {locpd=20300,yoe=10,iq=140}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=301,dr=10}
            Rubble2, Barney2, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble3, Barney3, 2/2/1905, Manager, {orgSize=400,dr=10}
            Rubble4, Barney4, 2/2/1905, Manager, {orgSize=200,dr=10}
            Rubble5, Barney5, 2/2/1905, Manager, {orgSize=360,dr=10}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flinstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
            Flinstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
            Flinstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
            Flinstone5, Wilma5, 3/3/1910, Analyst, {projectCount=7}
            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
            """;

        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(people);

        int totalSalaries =0;
        IEmployee employee = null;
        while (peopleMat.find()) {
            employee = Employee.createEmployee(peopleMat.group());
            Employee emp = (Employee) employee;
            boolean add = employees.add(employee);
            salaryMap.put(emp.firstname, emp.getSalary());
        }

        for (IEmployee worker : employees){
            System.out.println(worker.toString());
            totalSalaries+= worker.getSalary();
        }
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
        System.out.printf("The total payout should be %s%n", moneyFormatter.format(totalSalaries));
        System.out.println(employees.size());
    }

    private static void removeUndesirables(List<IEmployee> employees, List<String> removalNames){
        for(Iterator<IEmployee> it = employees.iterator(); it.hasNext();){
            IEmployee worker = it.next();
            if (worker instanceof Employee tmpWorker){
                if (removalNames.contains(tmpWorker.firstname)){
                    it.remove();
                }
            }
        }
    }

    public int getSalary(String firstName){
        return salaryMap.get(firstName);
    }

}