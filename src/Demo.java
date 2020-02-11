import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placeList = new LinkedList<String>();
        placeList.add("Sydney");
        placeList.add("Melbourne");
        placeList.add("Brisbane");
        placeList.add("Perth");
        placeList.add("Canberra");
        placeList.add("Adelaide");
        placeList.add("Darwin");
        printList(placeList);

        placeList.add(1, "Alice Springs");
        printList(placeList);
        placeList.remove(4);
        addInOrder(placeList, "New York");
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
                stringListIterator.add(newCity);
                return true;
            } else {
            }
        }
        stringListIterator.add(newCity);
        return true;
    }
}
