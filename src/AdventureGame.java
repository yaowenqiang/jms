import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame {
    private static Locations locations = new Locations();
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<>();

        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTh", "N");
        vocabulary.put("SOUTh", "S");
        vocabulary.put("EAST",  "E");
        vocabulary.put("WAST",  "W");

        int loc = 1;
         while(true) {
             //tempExit.remove('S');
             System.out.println(locations.get(loc).getDescription());
             if (loc == 0) {
                 break;
             }

             Map<String, Integer> exits = locations.get(loc).getExits();
             System.out.println("Available exits are ");
             for (String exit : exits.keySet()) {
                 System.out.print(exit + " , ");
             }

             System.out.println();
             String direction = scanner.nextLine().toUpperCase();
             if (direction.length() > 1) {
                 String[] words = direction.split(" ");
                 for (String  word : words) {
                     if (vocabulary.containsKey(word)) {
                         direction = vocabulary.get(word);
                         break;
                     }
                 }
             }
             if (exits.containsKey(direction)) {
                 loc = exits.get(direction);
             } else {
                 System.out.println("You cannot go in that direction.");
             }
//             if (!locations.containsKey(loc)) {
//                 System.out.println("You cannot go in that direction.");
//             }
         }


//         String[] road = "You are standing at the end of a road before a small brick building".split(" ");
//         String[] road = "You are standing at the end of a road before a small brick building".split(", ");
//
//         for (String i : road) {
//             System.out.println(i);
//         }
    }
}
