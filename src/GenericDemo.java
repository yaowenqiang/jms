import java.util.ArrayList;

public class GenericDemo {
    public static void main(String[] args) {
//        ArrayList<Integer> items = new ArrayList<Integer>();
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
//        items.add("abc");
        items.add(2);
        items.add(3);
        items.add(4);
        items.add(5);
        printDoubled(items);

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team adelaideCrows = new Team("adelaideCrows");
        adelaideCrows.addPlayer(joe);
        adelaideCrows.addPlayer(pat);
        adelaideCrows.addPlayer(beckham);
        System.out.println(adelaideCrows.numPlayers());
    }

    public static void printDoubled(ArrayList<Integer> n) {
//       for (Object i : n) {
       for (int i : n) {
//           System.out.println((Integer)i*2);
           System.out.println(i*2);
       }
    }
}
