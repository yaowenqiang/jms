public class DeluxeBurger extends Hamburger{
    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 14.54, "White");
        super.addHamburgerAddition1("Chips", 2.74);
        super.addHamburgerAddition2("Drink", 1.81);
    }


    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Can not add addition items to a deluxe burger.");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Can not add addition items to a deluxe burger.");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Can not add addition items to a deluxe burger.");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Can not add addition items to a deluxe burger.");
    }
}
