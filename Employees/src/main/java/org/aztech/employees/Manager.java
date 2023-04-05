package org.aztech.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee  {
    private int orgSize = 0;
    private int dr = 0;
    private final String managerRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
    private final Pattern managerPat = Pattern.compile(managerRegex);


    public Manager(String personText) {
        super(personText);
        Matcher managerMat = managerPat.matcher(peopleMat.group("details"));
        if (managerMat.find()){
            this.orgSize = Integer.parseInt(managerMat.group("orgSize"));
            this.dr = Integer.parseInt(managerMat.group("dr"));
        }
    }

    public int getSalary() {
        return 3000 + orgSize*dr;
    }
}
