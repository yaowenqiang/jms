import java.util.Scanner;

public class InterfaceDemo {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");
    private static Button btnPrint2 = new Button("Print");
    public static void main(String[] args) {
        ITelephone timesPhone;
//        DeskPhone timesPhone;
        timesPhone = new DeskPhone(123456);
        timesPhone.powerOn();
        timesPhone.callPhone(123456);
        timesPhone.answer();

        timesPhone = new MobilePhone(123456);
        timesPhone.powerOn();
        timesPhone.callPhone(123456);
        timesPhone.answer();


//        GearBox mcLaren = new GearBox(6);
//        GearBox.Gear first = mcLaren.new Gear(1, 12.3);
//        GearBox.Gear second = new GearBox.Gear(1, 15.4);
//        GearBox.Gear third = new mcLaren.Gear(2, 4.5);

        GearBox mcLaren = new GearBox(6);
//        mcLaren.addGear(1,5.3);
//        mcLaren.addGear(2,10.6);
//        mcLaren.addGear(3,15.9);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        mcLaren.wheelSpeed(6000);


//        System.out.println(first.driveSpeed(1000));

        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("I've been attached.");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked.");
            }

        }
        btnPrint.setOnClickListener(new ClickListener());
        btnPrint2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println("the click event was handled by the anonymous class,the new title is " + title);
            }
        });
        listen();
    }

    private static void listen() {
        boolean quit = false;
        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    //btnPrint.onClick();
                    btnPrint2.onClick();
            }

        }
    }
}
