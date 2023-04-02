import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressRegesCheck {
    public static void main(String[] args) {
        String address = "11929 W. Airport Blvd, Stafford, TX, USA";
        String regex = """
                            (?<buildingNumber>\\d+)[\\s,]+
                            (?<streetName>[\\w.\\s]+),\\s*
                            (?<city>[\\w.\\s]+),\\s*
                            (?<state>[\\w]*),\\s*
                            (?<country>[\\w.\\s]+)\\b.*
                            """;
        Pattern pat = Pattern.compile(regex, Pattern.COMMENTS | Pattern.DOTALL);
        Matcher mat = pat.matcher(address);
        System.out.println(mat.matches());
        System.out.println(mat.group("buildingNumber"));
        System.out.println(mat.group("streetName"));
        System.out.println(mat.group("city"));
        System.out.println(mat.group("state"));
        System.out.println(mat.group("country"));
    }
}
