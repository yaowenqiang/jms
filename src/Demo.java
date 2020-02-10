import java.util.Iterator;
import java.util.LinkedList;

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
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()) {
            System.out.println("New visiting " + i.next());
        }

    }
}
