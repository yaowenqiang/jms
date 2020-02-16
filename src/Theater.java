import java.util.ArrayList;
import java.util.List;

public class Theater {
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;

        int lastRow = 'A' +(numRows-1);

        for (char row ='a';row <= 'z';row++) {
            for (int setNum = 1; setNum < seatsPerRow;setNum++) {
                Seat seat = new Seat(row + String.format("%02d", setNum));
                seats.add(seat);
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat reservedSeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                reservedSeat = seat;
                break;
            }
        }

        if (reservedSeat == null) {
            System.out.println("There is no seat: " + seatNumber);
            return false;
        }

        return reservedSeat.reserved();

    }

    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
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
    }
}
