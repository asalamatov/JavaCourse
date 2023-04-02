import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressArrayExercise {
    public static void main(String[] args) {
        String addressesString = """
                12345 First Street, First City, AA 90210
                22222 Second Street, Second City, BB 22222
                33333 Third Street, Third City, CC 33333
                """;


        String regex = "(?<home>\\d+)\\s*(?<street>[\\w\\s]+),\\s*(?<city>[\\w\\s]+),\\s?(?<state>[A-Z]{2})?\\s*(?<zip>\\d{5})\\n";
        Pattern pat = Pattern.compile(regex, Pattern.COMMENTS);
        Matcher mat = pat.matcher(addressesString);
        while (mat.find()){
            System.out.printf("%s %s %s%n", mat.group("home"), mat.group("street"), mat.group("city"));
        }
    }
}
