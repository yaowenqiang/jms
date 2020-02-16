public class ScopeDemo {
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
//        System.out.println("varThree is not accessable here "+ innerClass2.varThree);



    }
}
