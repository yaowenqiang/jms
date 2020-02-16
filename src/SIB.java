//Static initialization block
public class SIB {
    public static final String owner;
    static {
        owner = "tim";
        System.out.println("SIP initialization block called. ");
    }

    public SIB() {
        System.out.println("SIB constructor called.");
    }

    static {
        System.out.println("Second initialization block called.");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }

}
