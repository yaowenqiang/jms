public class Car extends Vehicle{



    private int doors;
    private int wheels;
    private String engine;
    private String model;
    private String color;
    private boolean isManual;

    public Car(String name, String size, int currentVelocity, int currentDirection, int doors, int wheels, String engine, String model, String color) {
        super(name, size, currentVelocity, currentDirection);
        this.doors = doors;
        this.wheels = wheels;
        this.engine = engine;
        this.model = model;
        this.color = color;
    }

    public  void setModel(String model) {
        String validModel = model.toLowerCase();
        if (validModel.equals("carrera") || validModel.equals("commodore")) {
            this.model = model;
        } else {
            this.model = "unknown";
        }
    }

    public String getModel() {
        return this.model;
    }


}
