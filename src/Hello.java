public class Hello {
    public static void main(String[] args) {
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
        byte myHalfMinByteValue = (byte) (myMinByteValue / 2);
        System.out.println("myHalfMinByteValue: " + myHalfMinByteValue);
        byte myMaxByteValue = 127;
        System.out.println(myMinByteValue);
        System.out.println(myMaxByteValue);

        // short has a width of 16
        short myMinShortValue = -32768;
        short myHalfMinShortValue = (short) (myMinShortValue / 2);
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
        short shortTotal = (short) (1000 + 10 * (byteValue + shortValue + intValue));
        System.out.println("longTotal: " + longTotal);
        System.out.println("shortTotal: " + shortTotal);

        int myIntValue2 = 5;
        int myIntValue3 = 5 / 2;

        // width of float is 32 (4 bytes)
        float myFloatVal = 5F;
//        float myFloatVal = 5.4;
        float myFloatVal2 = (float) 5.4;
        float myFloatVal3 = 5F / 3F;

        // width of double is 64( 8 bytes)
        double myDoubleValue = 5D;
        double myDoubleValue2 = 5D / 3D;

        System.out.println("myIntValue2: " + myIntValue2);
        System.out.println("myIntValue3: " + myIntValue3);
        System.out.println("myFloatVal: " + myFloatVal);
        System.out.println("myFloatVal3: " + myFloatVal3);
        System.out.println("myDoubleValue: " + myDoubleValue);
        System.out.println("myDoubleValue2: " + myDoubleValue2);


        // double is recommended
        // double is faster on modern computers
        // double is more precise
        // many build-in function usually us a 'double' and thirdly

        // 1 pound = 0.45359237 kilograms

        double myPoundValue = 1;
        double myKkilogramValue = myPoundValue * 0.45359237;
        System.out.println(myPoundValue + " pound(s) is equals to " + myKkilogramValue + " kilogram(s)");

        double PI = 3.141_592_6d;
        System.out.println(PI);

        // width of char is 16 (2 bytes)
        char myChar = 'd';
        // https://unicode-table.com/en/#control-character

        char copyright = '\u00A9';
        System.out.println(copyright);

        char registed = '\u00AE';
        System.out.println(registed);

        boolean myBooleanVal = true;
        boolean isMale = false;
        System.out.println(myBooleanVal);
        System.out.println(isMale);

        String myString = "This is a string";
        System.out.println(myString);
        myString = myString + " and more";
        System.out.println(myString);

        myString = myString + " " + copyright + "2020";
        System.out.println(myString);

        String numberString = "250.55";
        numberString = numberString + "49.45";
        System.out.println(numberString);

        String lastString = "10";
        int myInt = 20;

        lastString = lastString + myInt;
        System.out.println(lastString);

        int result = 1 + 2;

        int newValue = 15;

//        if(newValue = 15)
        if (newValue == 15)
            System.out.println(newValue);

        boolean isCar = false;
//        if(isCar == true)
        if (isCar = true)
            System.out.println("This is supposed to happen.");


// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html

//        Java Operator Precedence Table
//        http://cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html


//        https://en.wikipedia.org/wiki/List_of_java_keywords

        if (1 > 0)


            System.out.println("this should  be executed!");

        System.out.println("this is executed!");


        int tmp = 100;
        System.out.println("tmp is " + tmp);
        if (true) {
            tmp = 1;
            int tmp2 = 2;
            System.out.println("tmp is " + tmp);
            System.out.println("tmp2 is " + tmp2);
//            the new variable will be destroyed after the code block is finished
        }
//        System.out.println("tmp2 is : " + tmp2);
        int tmp2 = 3;
        System.out.println("tmp2 is : " + tmp2);

        int result2 = calculateScore(true, 100, 1, 10);
        switchCase();
    }


    //    public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        System.out.println("calculateScore");
        return 100;
    }


    public static int calculateScore(int gameOver, int score, int levelCompleted, int bonus) {
        System.out.println("calculateScore");
        return 100;
    }

    public static void calculateScore() {
        System.out.println("calculateScore");
    }

    public static void feetToCentimeters() {
//        https://www.metric-conversions.org/length/feet-to-centimeters.htm
    }


//    public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
//        System.out.println("calculateScore");
//    }


    public static void switchCase() {
        int switchValue = 1;

        switch (switchValue) {
            case 1:
                System.out.println("equal to 1");
                break;
            case 2:
                System.out.println("equal to 2");
                break;
            case 3:
                System.out.println("equal to 3");
                break;
            case 4:case 5: case 6:
                System.out.println("between 4 and 6");
                break;

            default:
                System.out.println("unknown value");
                break;

        }

        String month = "January";


        switch(month.toLowerCase()) {
            case "January":
                System.out.println("Jan");
                break;
            case "June":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
                break;
        }

    }

}
