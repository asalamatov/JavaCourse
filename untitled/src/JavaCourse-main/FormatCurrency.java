import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.ParseException;

public class FormatCurrency {
    public static NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) throws ParseException {
        // Scanner sc = new Scanner(System.in);
        // double number = sc.nextDouble();
        // System.out.println(moneyFormatter.format(number));
        // sc.close();
        BigDecimal balance = (divideMoney("$12,345.83"));
        String a = moneyFormatter.format(balance);
        System.out.println(a);
    }

    public static BigDecimal divideMoney(String amount) throws ParseException{
        MathContext mc = new MathContext(10);
        return (new BigDecimal(moneyFormatter.parse(amount).toString())).divide(new BigDecimal("32.19"), mc);
    }
}
