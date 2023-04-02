import java.math.BigDecimal;
import java.text.DecimalFormat;


public class CustomFormat {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("$#,###.00;$(#)");
        DecimalFormat pf = new DecimalFormat("#%");
        BigDecimal number = new BigDecimal("167832.267287");
        System.out.println(df.format(-1000));
        System.out.println(pf.format(283));

        System.out.printf("$%,(.2f%n", number.negate());
    }
}
