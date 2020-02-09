import java.util.ArrayList;
import java.util.Scanner;

public class ArrayDemo {

    private static Scanner scanner = new Scanner(System.in);
//    private static int[] baseArray = new int[10];
    private static int[] baseArray = {0,1,2,3,4,5,6,7,8,9};
    private static GroceryList groceryList = new GroceryList();
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


//        int[] arrayIntegers = getIntegers(11);
//
//        printArray(arrayIntegers);
//
//        System.out.println("The average is " + getAverage(arrayIntegers));

        resizeArray();
        System.out.println("the new lengh of baseArray is " + baseArray.length);

        //https://docs.oracle.com/javase/8/docs/api/java/util/List.html

        //https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html



        boolean quit = false;
        int choice = 0;
        printInstructions();

        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryItem();
                    break;
                case 2:
                    addIem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
                case 7:
                    processArrayList();
                    break;
            }
        }

//        Integer myInt = new Integer(11);
        Integer myInt = 11;//Integer.valueOf(11)
//        Double myDouble = new Double(1.11);
        int myIntValue = myInt;//myInt.intValue();
        Double myDouble = 1.11; //Double.valueOf(1.11)

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            intArrayList.add(Integer.valueOf(i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " -> " + intArrayList.get(i).intValue());
        }








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

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item to the list.");
        System.out.println("\t 4 - To remove an item to the list.");
        System.out.println("\t 5 - To search en item from the list.");
        System.out.println("\t 6 - To quit the application.");
        System.out.println("\t 6 - To copy the List.");
    }

    public static void addIem() {
        System.out.print("Please enter the grocery item: ");
        String stringInput = scanner.next();
        groceryList.addGroceryItem(stringInput);
    }
    public static void modifyItem() {
        System.out.print("Enter item name: ");
        String item = scanner.next();
        System.out.print("Enter replacement item: ");
        String newItem = scanner.next();
        groceryList.modifyGroceryItem(item, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter item to be removed: ");
        String item = scanner.next();
        groceryList.removeGroceryItem(item);
    }

    public static void searchForItem() {
        System.out.print("Enter item to search for: ");
        String searchItem = scanner.next();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " not no file");
        }

    }

    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<String>() ;
        ArrayList<String> newArray2 = new ArrayList<String>(groceryList.getGroceryList()) ;
        newArray.addAll(groceryList.getGroceryList());
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}
