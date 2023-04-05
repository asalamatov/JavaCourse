package org.aztech.employees;

public class Nobody extends Employee{
    public int getSalary() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Nobody class was used");
    }
    public Nobody(){
        super("");
    }
}
