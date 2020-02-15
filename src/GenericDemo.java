import java.util.ArrayList;
import java.util.Collections;

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

        Team<FootballPlayer> adelaideCrows = new Team<>("adelaideCrows");
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);
        System.out.println(adelaideCrows.numPlayers());
        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);
        System.out.println(baseballTeam.numPlayers());

        Team<SoccerPlayer> brokenTeam = new Team<>("this won't work");
//        brokenTeam.addPlayer("no-one");
        brokenTeam.addPlayer(beckham);

//        Team<String> brokenTeam = new Team("this won't work");
//        brokenTeam.addPlayer("no-one");

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gorden");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2,1);
//        adelaideCrows.matchResult(baseballTeam, 1,1);

        System.out.println("Rankings:");
        System.out.println(adelaideCrows.getName() +  ": " + adelaideCrows.ranking());
        System.out.println(melbourne.getName() +  ": " + melbourne.ranking());
        System.out.println(fremantle.getName() +  ": " + fremantle.ranking());
        System.out.println(hawthorn.getName() +  ": " + hawthorn.ranking());

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(adelaideCrows.compareTo(fremantle));

        ArrayList<Team> teams = new ArrayList<>();
        teams.add(adelaideCrows);
        teams.add(melbourne);
        teams.add(fremantle);
        Collections.sort(teams);
    }

    public static void printDoubled(ArrayList<Integer> n) {
//       for (Object i : n) {
       for (int i : n) {
//           System.out.println((Integer)i*2);
           System.out.println(i*2);
       }
    }
}
