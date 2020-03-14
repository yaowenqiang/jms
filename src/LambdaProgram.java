public class LambdaProgram {
    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("printing from the Runnable.");
//            }
//        }).start();
        new Thread(()-> {
            System.out.println("printing from the line1");
            System.out.println("printing from the line2");
            System.out.println("printing from the line3");
            System.out.println("printing from the line4");
            System.out.println(String.format("This is line %d", 5));
        }).start();
    }
}

class CodeToRun implements Runnable
{
    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}
