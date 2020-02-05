import java.util.Scanner;

public class ArrayDemo {

    private static Scanner scanner = new Scanner(System.in);
//    private static int[] baseArray = new int[10];
    private static int[] baseArray = {0,1,2,3,4,5,6,7,8,9};
    public static void main(String[] args) {
        int[] myIntArray = new int[10];
        myIntArray[5] = 50;
        double[] myDoubleArray = new double[10];
        System.out.println(myDoubleArray[5]);

        int[] myIntArray2 = {1,2,3,4,5,6,7,8,9,10};

        int[] myIntArray3 = new int[10];
        for (int i = 0; i < 10; i++) {
            myIntArray3[i] = i;
        }

        int[] myIntArray4 = new int[10];
        for (int i = 0; i < myIntArray4.length; i++) {
            myIntArray4[i] = i;
        }
        printArray(myIntArray4);


        int[] arrayIntegers = getIntegers(11);

        printArray(arrayIntegers);

        System.out.println("The average is " + getAverage(arrayIntegers));

        resizeArray();
        System.out.println("the new lengh of baseArray is " + baseArray.length);

        //https://docs.oracle.com/javase/8/docs/api/java/util/List.html

        //https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html







    }

    public static  void  printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " , value is " + array[i]);
        }
    }

    public static void  resizeArray()
    {
        int[] original = baseArray;
        baseArray = new int[12];
        for (int i = 0; i < original.length;i++) {
            baseArray[i] = original[i];
        }

    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values: \r");
        int[] values = new int[number];

        for (int i = 0; i < values.length;i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }


    public static double getAverage(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length;i++) {
            sum += array[i];
        }
        return sum / array.length;

    }


    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length;i++) {
            sortedArray[i] = array[i];
        }

        boolean flag = true;
        int temp;

        while(flag) {
           flag = false;

           for(int i = 0; i < sortedArray.length -1;i++) {
               if(sortedArray[i] <= sortedArray[i+1]) {
                   temp = sortedArray[i];
                   sortedArray[i] = sortedArray[i+1];
                   sortedArray[i+1] = temp;
                   flag = true;
               }
           }
        }
        return sortedArray;
    }

}
