package org.aztech.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO  extends Employee {
    private int avgStockPrice = 0;

    private final String CEORegex = "\\w+=(?<avgStockPrice>\\w+)";
    private final Pattern CEOPat = Pattern.compile(CEORegex);
    private Pilot pilot = new Pilot(1000, true);


    public CEO(String personText) {
        super(personText);
        Matcher CEOMat = CEOPat.matcher(peopleMat.group("details"));
        if (CEOMat.find()){
            this.avgStockPrice = Integer.parseInt(CEOMat.group("avgStockPrice"));
        }
    }

    public int getSalary() {
        return 5000 + avgStockPrice;
    }

    public void fly() {
        pilot.fly();
    }

    public int getHoursFlown() {
        return pilot.getHoursFlown();
    }

    public void setHoursFlown(int hoursFlown) {
        pilot.setHoursFlown(hoursFlown);
    }

    public boolean isIfr() {
        return pilot.isIfr();
    }

    public void setIfr(boolean ifr) {
        pilot.setIfr(ifr);
    }
}

