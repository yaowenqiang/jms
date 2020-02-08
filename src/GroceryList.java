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

    private void  modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery Item " + position + " has been modified.");
    }

    public void  removeGroceryItem(String item) {
        int position = findItem(item);
        if (position >= 0) {
            removeGroceryItem(position);
        }
    }

    private void  removeGroceryItem(int position) {
        groceryList.remove(position);
        System.out.println("Grocery Item " + position + " has been removed.");
    }

    private int  findItem(String searchItem) {
        return  groceryList.indexOf(searchItem);
    }
    public boolean  onFile(String searchItem) {
        int position = findItem(searchItem);
        if (position >= 0) {
            return true;
        }
        return false;
    }

    public void  modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if (position >= 0) {
            modifyGroceryItem(position, newItem);
        }
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }
}
