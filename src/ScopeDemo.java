public class ScopeDemo {
    public static int multiplier = 7;

    public static void main(String[] args) {
        String varFour = "This is private to main()";
        ScopeCheck scopeInstance = new ScopeCheck();
        System.out.println("scopeInstance varOne is " + scopeInstance.getVarOne());
        System.out.println(varFour);
        scopeInstance.timesTwo();

        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();

        scopeInstance.useInner();

        ScopeCheck.InnerClass innerClass2 = scopeInstance.new InnerClass();
//        System.out.println("varThree is not accessible here "+ innerClass2.varThree);

//        Scanner scanner = new Scanner(System.in);
//        X x = new X(scanner.nextInt());
//        X x = new X(new Scanner(System.in));
//        x.x();

        Accounts myAccount = new Accounts("jack");

        myAccount.deposit(1000);
        myAccount.withdraw(500);
        myAccount.withdraw(-200);
        myAccount.deposit(-20);
        myAccount.deposit(-200);
        myAccount.calculateBalance();
//        myAccount.balance = 5000;
        System.out.println("Balance on account is " + myAccount.getBalance());
//        myAccount.transactions.add(500);
        myAccount.calculateBalance();

        StaticTest firstInstance = new StaticTest("1st instance");
//        System.out.println(firstInstance.getName() + " is instance number " + firstInstance.getNumInstance());
        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstance());
        StaticTest secondInstance = new StaticTest("2nd instance");
        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstance());


        int answer =  multiply(6);
        System.out.println("The answer is " + answer);
        System.out.println("multiplier is " + multiplier);

        FinalDemo one = new FinalDemo("one");
        FinalDemo two = new FinalDemo("tow");
        FinalDemo three = new FinalDemo("three");
        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        System.out.println(Math.PI);


        int pw = 674321;
        Password password = new Password(pw);
        password.storePassword();
        password.letMeIn(1);
        password.letMeIn(0);
        password.letMeIn(-1);
        password.letMeIn(674321);


        ExtendPassword password2 = new ExtendPassword(pw);
        password2.storePassword();

        System.out.println("Main method called.");

        SIB sib = new SIB();
        sib.someMethod();
        System.out.println("Owner is " + SIB.owner);

    }

    public static int multiply(int number) {
        return number * multiplier;
    }
}
