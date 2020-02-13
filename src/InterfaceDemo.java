public class InterfaceDemo {
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
    }
}
