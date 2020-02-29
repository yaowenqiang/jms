import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ThrowExample {
    public static void main(String[] args) {
        try {
           int result = divide();
            System.out.println(result);
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("unable to perform division, autopilot shutting down. ");
        }
        int result = divide();
        System.out.println(result);
    }

    private static int divide() {
        /*
        int x;
        try {
            x = getInt();
        } catch (NoSuchElementException e) {
            x = getInt();
        }
        int x = getInt();
        int y = getInt();
        */
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + " , y is " + y);
            return x / y;
        } catch (NoSuchElementException e) {
            //System.out.println("no suitable input");
            throw new NoSuchElementException("no suitable input");
        } catch (ArithmeticException e) {
            throw  new ArithmeticException("attempt to divide by zero");
        }
    }
    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer.");
        // cmd + d / ctrl + d  to send a EOF file character
        //return s.nextInt();
        while(true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("Please enter a number using only digits 0 through 9. ");
            }
        }
    }
}
