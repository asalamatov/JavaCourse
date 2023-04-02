import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailVerification {
    public static void main(String[] args) {
        String email = "first.last@domain.com";
        float i = 2.15f;
        float j = 1.10f;
        System.out.println(i-j);
    }

    public static boolean isValidEmail(String email){
        String regex = "[\\w.]+@[a-z]+\\.[a-z]+";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(email);
        return mat.matches();
    }
}
