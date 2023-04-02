import java.util.Locale;

public class ControlFlow {
    public static void main(String[] args) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : weekDays){
            String msg = "We eat %s on %s";
            String msgFinal =  switch (day) {
                    case "Monday" -> "pot roast may";
                    case "Tuesday" -> "spaghetti";
                    case "Wednesday" -> {
                        if ("Wednesday".equals(day)) {
                            yield "nan";
                        } else{
                            yield "tacos";
                        }
                    }
                    default -> "pizza";
                };
            System.out.printf("We eat %s on %s%n", capFood(msgFinal), day);
        }
        System.out.println(countCharsInArray(weekDays));

    }

    private static String capFood(String foodName){
        String foodNameModified =  foodName.substring(0,1).toUpperCase() + foodName.substring(1);
        String foodNameParts[] = foodName.split(" ");
        StringBuilder sb = new StringBuilder(foodName.length());
        for (String part : foodNameParts){
            sb.append(part.substring(0,1).toUpperCase()).append(part.substring(1)).append(" ");
        }
        return sb.toString().strip();
    }

    private static int countCharsInArray(String strs[]){
        int count = 0;
        for (String str : strs){
            count+=str.length();
        }
        return count;
    }
}
