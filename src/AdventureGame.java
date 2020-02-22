import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame {
    private static Map<Integer,Location> locations = new HashMap<Integer,Location>();
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0,new Location(0,"You are sitting in front of a computer learning Java", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("W", 5);
        locations.put(1,new Location(1,"You are standing at the end of a road before a  small brick building", tempExit));
//        locations.get(1).addExit("Q", 0);
        //https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
//        locations.get(2).addExit("Q", 0);
        locations.put(2,new Location(2,"You are at the top of a hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
//        locations.get(3).addExit("Q", 0);
        locations.put(3,new Location(3,"You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
//        locations.get(4).addExit("Q", 0);
        locations.put(4,new Location(4,"You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
//        locations.get(5).addExit("Q", 0);
        locations.put(5,new Location(5,"You are in the forest", tempExit));

        Map<String, String> vocabulary = new HashMap<>();

        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTh", "N");
        vocabulary.put("SOUTh", "S");
        vocabulary.put("EAST",  "E");
        vocabulary.put("WAST",  "W");





        int loc = 1;
         while(true) {
             tempExit.remove('S');
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
