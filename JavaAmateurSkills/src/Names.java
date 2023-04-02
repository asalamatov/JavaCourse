public class Names {
    static int count = 0;
    public static void main(String[] args) {
        String [] names = {
            "name1",
            "name2",
            "name3",
            "name4",
            "name5",
            "name6",
            "name7",
        };
        System.out.println(next(names));
        System.out.println(next(names));
        System.out.println(next(names));
        System.out.println(next(names));
        System.out.println(next(names));
        System.out.println(next(names));

    }

    public static String next(String [] names){
        count++;
        return names[count-1];
    }
}
