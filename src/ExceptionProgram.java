import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionProgram {
    public static void main(String[] args) {
        //LBYL(look before you leap)
        //EAFP(Easy to Ask For forgiveness then permission)
        //https://www.kawabangga.com/posts/3022
        int x = 80;
        int y = 0;
        System.out.println(divideEAFP(x,y));
        System.out.println(divideLBYL(x,y));
//        System.out.println(divide(x,y));
        int a = getInt();
        System.out.println("a is " + a);
        int b = getIntLBYL();
        System.out.println("b is " + b);
        int c = getIntEAFP();
        System.out.println("c is " + c);
    }

    private static int divideLBYL(int x, int y){
       if (y != 0) {
           return x / y;
       } else {
           return 0;
       }
    }

    private static int divideEAFP(int x, int y){
        try {
            return x / y;
        } catch(ArithmeticException e) {
            return 0;
        }
    }

    private static int divide(int x, int y){
        return x / y;
    }
    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int getIntLBYL() {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer: ");
        String input = scanner.next();
        for (int i=0;i<input.length();i++) {
           if (!Character.isDigit(input.charAt(i))) {
               isValid = false;
               break;
           }
        }
        if (isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        try {
            return s.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }
}
