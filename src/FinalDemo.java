public class FinalDemo {
    private static int classCounter = 0;
    public final int instanceNumber;
    private final  String name;

    public FinalDemo(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " created, instance id: " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}

