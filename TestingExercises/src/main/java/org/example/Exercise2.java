package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise2 {
    public static String getName(String info){
        String regex = "(?<name>\\w+)";
        Pattern pat = Pattern.compile(regex, Pattern.COMMENTS);
        Matcher mat = pat.matcher(info);
        mat.find();
        return mat.group("name");
    }

    public static String getSurname(String info){
        String regex = "\\w+,\\s*(?<surname>\\w+)";
        Pattern pat = Pattern.compile(regex, Pattern.COMMENTS);
        Matcher mat = pat.matcher(info);
        mat.find();
        return mat.group("surname");
    }
}
