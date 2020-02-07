import java.util.ArrayList;

public class GroceryList {
    private int[] myMembers = new int[10];
    private ArrayList<String> groceryList = new ArrayList<String>();


    public void  addGroceryItem(String item) {
//       myMembers[5] = 4;
       groceryList.add(item);
    }

    public void  printGroceryItem() {
        System.out.println("You have " + groceryList.size() + " items in your grocey list.");
        for (int i=0; i < groceryList.size();i++) {
            System.out.println((i + 1) + ", "  + groceryList.get(i));
        }
    }

    public void  modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery Item " + position + " has been modified.");
    }

    public void  removeGroceryItem(int position) {

        String theItem = groceryList.get(position);
        groceryList.remove(position);
        System.out.println("Grocery Item " + position + " has been removed.");
    }

    public String  findItem(String searchItem) {
//        boolean exists = groceryList.contains(searchItem);
        int position = groceryList.indexOf(searchItem);
        if (position >=0) {
            return groceryList.get(position);
        }
        return null;
    }
}
