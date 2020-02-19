import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {
        Theater theater = new Theater("Beijing", 2, 3);
//        theater.getSeats();
        if (theater.reserveSeat("F01")) {
            System.out.println("Please pay!");
        } else {
            System.out.println("Sorry, seat is taken.");
        }
//        if (theater.reserveSeat("F01")) {
//            System.out.println("Please pay!");
//        } else {
//            System.out.println("Sorry, seat is taken.");
//        }

        //shallow copy
        List<Theater.Seat> seatCopy = new ArrayList<>(theater.seats);
        printList(seatCopy);
        seatCopy.get(1).reserved();
        if (theater.reserveSeat("A02")) {
            System.out.println("Please pay A202");
        } else {
            System.out.println("Sea already reserved!");
        }

//        Collections.reverse(seatCopy);
        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theater.seat");
        printList(theater.seats);
        Theater.Seat minSeat = Collections.min(seatCopy);
        Theater.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("printing sorted seatCopy");
        printList(seatCopy);

//        List<Theater.Seat> newList = new ArrayList<>(theater.seats.size());
//        Collections.copy(newList, theater.seats);

        List<Theater.Seat> reverseSeats = new ArrayList<>(theater.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);
    }

    public static void printList(List<Theater.Seat> list) {
        for (Theater.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("====================");
    }

    public static void sortList(List<? extends Theater.Seat> list) {
        for (int i = 0; i < list.size();i++) {
//            for (int j = 0; j < list.size();j++) {
            for (int j = i+1; j < list.size();j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
//                if (list.get(i).compareTo(list.get(j)) < 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
