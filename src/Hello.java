public class Hello {
    public static void main(String[] args)
    {
        // integer has a width of 32
//        System.out.println("Hello World");
        int myFirstNumber = 5;
//        System.out.println(myFirstNumber);

//        int myMinValue = -2147483649;
        int myMinValue = -2147483648;
        int myMinValue1 = -2_147_483_648;
        int myMinValue2 = -21_4748_3648;
        int myMaxValue = 2147483647;
        System.out.println(myMinValue);
        System.out.println(myMinValue1);
        System.out.println(myMinValue2);
        System.out.println(myMaxValue);

        // byte has a width of 8
        byte myMinByteValue = -128;
        byte myHalfMinByteValue = (byte)(myMinByteValue/2);
        System.out.println("myHalfMinByteValue: " + myHalfMinByteValue);
        byte myMaxByteValue = 127;
        System.out.println(myMinByteValue);
        System.out.println(myMaxByteValue);

        // short has a width of 16
        short myMinShortValue = -32768;
        short myHalfMinShortValue = (short)(myMinShortValue/2);
        System.out.println("myHalfMinShortValue: " + myHalfMinShortValue);
        short myMaxShortValue = 32767;
        System.out.println(myMinShortValue);
        System.out.println(myMaxShortValue);


        // short has a width of 64
        long myMinLongValue = -9_223_372_036_854_775_808L;
        long myMaxLongValue = 9_223_372_036_854_775_807L;
        System.out.println(myMinLongValue);
        System.out.println(myMaxLongValue);


        byte byteValue = 10;
        short shortValue = 20;
        int intValue = 50;

        long longTotal = 50000L + 10L * (byteValue + shortValue + intValue);
        short shortTotal = (short)(1000 + 10 * (byteValue + shortValue + intValue));
        System.out.println("longTotal: " + longTotal);
        System.out.println("shortTotal: " + shortTotal);

    }

}
