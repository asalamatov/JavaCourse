package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise2 {

    private static final String regex = "(?<name>\\w+),\\s*(?<surname>\\w+),\\s*(?<street>[\\w\\s\\.]+),\\s*(?<city>[\\w\\s\\.]+),\\s*(?<state>[\\w\\s\\.]*),\\s*(?<zip>[\\w-]+)\\s*\\|?\\s*";
    private static final Pattern pat = Pattern.compile(regex);
    private static Matcher mat;

    public static String getName(String info){
         mat = pat.matcher(info);
        mat.find();
        return mat.group("name");
    }

    public static String getSurname(String info){
         mat = pat.matcher(info);
        mat.find();
        return mat.group("surname");
    }

    public static String getStreet(String info){
         mat = pat.matcher(info);
        mat.find();
        return mat.group("street");
    }

    public static String getCity(String info){
         mat = pat.matcher(info);
        mat.find();
        return mat.group("city");
    }

    public static String getState(String info){
         mat = pat.matcher(info);
        mat.find();
        return mat.group("state");
    }

    public static String getZipCode(String info){
        mat = pat.matcher(info);
        mat.find();
        return mat.group("zip");
    }

//    public static List<Person> generateArrayOfPeople(String info){
//        mat = pat.matcher(info);
//        List<Person> array = new ArrayList<>();
//        while (mat.find()){
//            array.add(addPerson(info));
//        }
//        return array;
//    }

    public static List<String> getTwoNames(String info){
        mat = pat.matcher(info);
        List<String> array = new ArrayList<>();
        while (mat.find()){
            array.add(mat.group("name"));

        }
        return array;
    }



    public static Person addPerson(String address){
        Person person = new Person(
                getName(address),
                getSurname(address),
                getStreet(address),
                getCity(address),
                getState(address),
                getZipCode(address)
                );
        return person;
    }

//    public static void main(String[] args) {
//        System.out.println(generateArrayOfPeople("Billy, Bob, 1234 Big St., Big City, California, 90210 | Joe,Smith,5678 Little St.,Little City, New York, 20109"));
//    }

}
