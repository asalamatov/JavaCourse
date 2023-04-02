public class Warehouse {
    public static int count = 0;
    public static void main(String[] args) {
        int items[] = {
            13, 49, 90, 130, 175, 181, 255, 310, 330, 359
        };
        System.out.println(next(items));
        System.out.println(next(items));
        System.out.println(next(items));
        System.out.println(next(items));
        System.out.println(next(items));
        System.out.println(next(items));
        System.out.println(next(items));
        System.out.println(next(items));

    }

    public static int next(int[] items){
        count++;
        int clas = items[count-1];
        if (clas <=89){return 0;}
        else if (clas <=179){return 1;}
        else if (clas <=269){return 2;}
        else {return 3;}
    }
}
