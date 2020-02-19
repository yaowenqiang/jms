import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


//https://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html
public class Demo {
    public int intVar;
    public static void main(String[] args) {
        LinkedList<String> placeList = new LinkedList<String>();
//        placeList.add("Sydney");
        addInOrder(placeList, "Sydney");
//        placeList.add("Melbourne");
        addInOrder(placeList,"Melbourne");
//        placeList.add("Brisbane");
        addInOrder(placeList,"Brisbane");
//        placeList.add("Perth");
        addInOrder(placeList,"Perth");
//        placeList.add("Canberra");
        addInOrder(placeList,"Canberra");
//        placeList.add("Adelaide");
        addInOrder(placeList,"Adelaide");
//        placeList.add("Darwin");
        addInOrder(placeList,"Darwin");
        printList(placeList);

//        placeList.add(1, "Alice Springs");
        addInOrder(placeList, "Alice Springs");
        printList(placeList);
        placeList.remove(4);
        addInOrder(placeList, "New York");
        visit(placeList);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()) {
            System.out.println("New visiting " + i.next());
        }
    }

    public static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                //equal , do not add
                System.out.println(newCity + "is already include as a destination.");
                return false;
            } else if (comparison > 0) {
                stringListIterator.previous();
                //insert before current element ,i.e
                //LinkList = "hello"
                //LinkList.add("world")
                // "hello" => "world" -> "hello"
                stringListIterator.add(newCity);
                return true;
            } else {
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    public static void visit(LinkedList<String> cities) {
       Scanner scanner = new Scanner(System.in);
       boolean quite = false;
       boolean goingForward = true;
       ListIterator<String> listIterator = cities.listIterator();
       if(cities.isEmpty()) {
           System.out.println("No cities in the itenerary");
           return;
       } else {
           System.out.println("Now visiting " + listIterator.next());
           printMenu();
       }
       while(!quite) {
           int action = scanner.nextInt();
           scanner.nextLine();

           switch (action) {
               case 0:
                   System.out.println("Holiday(Vacation over.");
                   quite = true;
                   break;
               case 1:
                   if (!goingForward) {
                       if (listIterator.hasPrevious()) {
                           listIterator.previousIndex();
                       }
                       goingForward = true;
                   }
                   if (listIterator.hasNext()) {
                       System.out.println("Now visiting " + listIterator.next());
                   } else {
                       System.out.println("Reached the end of the list.");
                       goingForward = false;
                   }
                   break;
               case 2:
                   if (goingForward) {
                       if (listIterator.hasPrevious()) {
                           listIterator.previous();
                       }
                       goingForward = false;
                   }
                   if (listIterator.hasPrevious()) {
                       System.out.println("now visiting " + listIterator.previous());
                   } else {
                       System.out.println("We are at the start of the list.");
                       goingForward = true;
                   }
                   break;
               case 3:
                   printMenu();
                   break;
               default:
                   break;
           }
       }
    }

    public static void printMenu() {
        System.out.println("Available action:\npress ");
        System.out.println("1 - go to next city.");
        System.out.println("2 - go to previous city.");
        System.out.println("3 - print menu options.");
    }
}
