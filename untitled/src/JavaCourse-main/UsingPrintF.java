import java.text.DecimalFormat;

public class UsingPrintF {
    public static void main(String[] args) {
        

        String a = "123456.783";
        String b = "-9876.32532";
        String c = "23.19283928294829182";
        String d = "123456";
        String e = "-9876.35532";
        System.out.printf("$%(,.2f%n", Float.parseFloat(a)); 
        String aa = String.format("$%(,.2f%n", Float.parseFloat(a));
        System.out.println(aa);
        System.out.printf("%(,.3f%n", Double.parseDouble(b));
        String bb = String.format ("%(,.3f%n", Double.parseDouble(b));
        System.out.println(bb);
        System.out.printf("%ef%n", Float.parseFloat(c)); 
        System.out.printf("%010d%n", Integer.parseInt(d));
        System.out.printf("%.1f%n", Float.parseFloat(e));
        DecimalFormat df = new DecimalFormat("$#,###.##");
        System.out.println(df.format(Float.parseFloat(a)));

        System.out.println("**************");
        System.out.println(addStrings("37", "13"));
    }

    public static int addStrings(String a, String b){
        return Integer.parseInt(a) + Integer.parseInt(b);
    }
}