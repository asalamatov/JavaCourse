import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.ParseException;

public class MathStuff {
    public static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
    public static final NumberFormat percentFormatter = NumberFormat.getPercentInstance();

    public static void main(String[] args) throws ParseException {
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
        BigDecimal balance = (calculate("$12,345.83", "8%", 10, "$1,000"));
        System.out.println(moneyFormatter.format(balance));
    }

    public static BigDecimal calculate(String principal, String rate, int year, String contribution) throws ParseException{
        String ratePercent = percentFormatter.parse(rate).toString();
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(ratePercent)).pow(year);
        BigDecimal c = a.subtract(BigDecimal.ONE);
        MathContext mc = new MathContext(10);
        BigDecimal d = c.divide(new BigDecimal(ratePercent,mc));
        BigDecimal e = d.multiply(new BigDecimal(moneyFormatter.parse(contribution).toString()));
        BigDecimal f = e.add((new BigDecimal(moneyFormatter.parse(principal).toString())).multiply(a));
        return f;
    }

}
