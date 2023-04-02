import java.security.SecureRandom;

public class RandomSum {
    public static short sum = 0;
    public static void main(String[] args) {
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());

    }

    public static short next() {
        SecureRandom random = new SecureRandom();
        int ran = random.nextInt(10);
        sum+=ran;
        return sum;
    }
}
