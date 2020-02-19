import java.util.*;

//https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html

public class Theater {
    private final String theaterName;
    public List<Seat> seats = new ArrayList<>();
//    private List<Seat> seats = new LinkedList<>();
//    private Collection<Seat> seats = new HashSet<>();
//    private Collection<Seat> seats = new LinkedHashSet<>();
//    private Collection<Seat> seats = new TreeSet<>();

     static final  Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
         @Override
         public int compare(Seat seat1, Seat seat2) {
             if (seat1.getPrice() < seat2.getPrice()) {
                 return -1;
             } else if (seat1.getPrice() > seat2.getPrice()) {
                 return 1;
             } else {
                 return 0;
             }
         }
     };

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;

        int lastRow = 'A' +(numRows-1);

        for (char row ='A';row <= lastRow;row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow;seatNum++) {
                double price = 12.00;
                if ((row < 'D') && (seatNum >=4) && (seatNum <= 9)) {
                    price = 14.00;
                } else if ((row > 'F') || (seatNum < 4) || (seatNum >9) ) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }

    /*
    public boolean reserveSeat(String seatNumber) {
        Seat reservedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, reservedSeat, null);
        if (foundSeat >=0) {
            return seats.get(foundSeat).reserved();
        } else {
            System.out.println("There is not seat " + seatNumber);
            return false;
        }
//        for (Seat seat : seats) {
//            System.out.print('.');
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                reservedSeat = seat;
//                break;
//            }
//        }

//        if (reservedSeat == null) {
//            System.out.println("There is no seat: " + seatNumber);
//            return false;
//        }
//
//        return reservedSeat.reserved();

    }
     */


    public boolean reserveSeat(String seatNumber) {
        int low = 0;
        int high = seats.size()-1;
        while (low <= high) {
            System.out.print('.');
            int mid = (low + high) / 2;
            Seat midSeat = seats.get(mid);
            int cmp = midSeat.getSeatNumber().compareTo(seatNumber);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
               high = mid -1;
            } else {
                return seats.get(mid).reserved();
            }
        }

        System.out.println("There is no seat " + seatNumber);
        return false;

    }

//    public void getSeats() {
//        for (Seat seat : seats) {
//            System.out.println(seat.getSeatNumber());
//        }
//    }
//
    public Collection<Seat> getSeats() {
        return seats;
    }



    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;
        private double price;


        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public boolean reserved() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("seat " + seatNumber + " reserved.");
                return true;
            } else {
                System.out.println("seat " + seatNumber + " is already reserved.");
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled.");
                return true;
            } else {
                System.out.println("seat " + seatNumber + " is not reserved.");
                return false;
            }
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public double getPrice() {
            return price;
        }
    }
}
