public class CollectionDemo {
    public static void main(String[] args) {
        Theater theater = new Theater("Beijing", 10, 10);
        theater.getSeats();
        if (theater.reserveSeat("f01")) {
            System.out.println("Please pay!");
        } else {
            System.out.println("Sorry, seat is taken.");
        }
        if (theater.reserveSeat("f01")) {
            System.out.println("Please pay!");
        } else {
            System.out.println("Sorry, seat is taken.");
        }
    }
}
