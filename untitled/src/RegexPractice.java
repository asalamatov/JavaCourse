import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {
    public static void main(String[] args) {
        String regex = """
(?:(?<countryCode>\\d{1,2})[-,.\\s]?)? # gets country code
(?:(?<areaCode>\\d{3})[-,.\\s]?) #gets areacode
(?:(?<exchange>\\d{3})[-,.\\s]?) #gets exchange
(?<lineNumber>\\d{4}) #gets lineNumber
""";
        String phoneNumber = "1.234.456.2345";
        System.out.println(phoneNumber.matches(regex));

        Pattern pat = Pattern.compile(regex, Pattern.COMMENTS);
        Matcher mat = pat.matcher(phoneNumber);
        if(mat.matches()){
            System.out.println(mat.group("countryCode"));
            System.out.println(mat.group("areaCode"));
            System.out.println(mat.group("exchange"));
            System.out.println(mat.group("lineNumber"));
        }

    }
}
