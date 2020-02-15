public abstract class Bird extends Animals implements CanFly{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + "is pecking.");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in ,breaths out, repeat.");
    }
//    public abstract void fly();

    @Override
    public void fly() {
        System.out.println(getName() + " is flapping its wings.");
    }
}
