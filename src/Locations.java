import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
public class Locations implements Map<Integer, Location> {
  private static Map<Integer, Location> locations = new HashMap<>();
    public static void main(String[] args) throws IOException {
        /*
        FileWriter locFile = null;
        try {
            locFile = new FileWriter("location.txt");
            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
//                throw new IOException("test exception wile writing.");
            }
//        } catch (IOException e) {
//            System.out.println("in catch block");
//            e.printStackTrace();
        } finally {
            System.out.println("into finally block.");
            //try {
                if (locFile != null) {
                    System.out.println("tempting to close locFile");
                    locFile.close();
                }
            //}
//            catch (IOException e) {
//                e.printStackTrace();
//            }
        }
*/
        try (FileWriter locFile = new FileWriter("locations.txt");
                FileWriter dirFile = new FileWriter("directions.txt")) {
            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction  +  ","  + location.getExits().get(direction) + "\n");
                }
            }
        }

    }
  static {
        /*
      Map<String, Integer> tempExit = new HashMap<>();
      locations.put(0,new Location(0,"You are sitting in front of a computer learning Java", tempExit));

      tempExit = new HashMap<>();
      tempExit.put("W", 2);
      tempExit.put("E", 3);
      tempExit.put("S", 4);
      tempExit.put("W", 5);
      locations.put(1,new Location(1,"You are standing at the end of a road before a  small brick building", tempExit));
//        locations.get(1).addExit("Q", 0);
      //https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html

      tempExit = new HashMap<>();
      tempExit.put("N", 5);
//        locations.get(2).addExit("Q", 0);
      locations.put(2,new Location(2,"You are at the top of a hill", tempExit));

      tempExit = new HashMap<>();
      tempExit.put("W", 1);
//        locations.get(3).addExit("Q", 0);
      locations.put(3,new Location(3,"You are inside a building, a well house for a small spring", tempExit));

      tempExit = new HashMap<>();
      tempExit.put("N", 1);
      tempExit.put("W", 2);
//        locations.get(4).addExit("Q", 0);
      locations.put(4,new Location(4,"You are in a valley beside a stream", tempExit));

      tempExit = new HashMap<>();
      tempExit.put("S", 1);
      tempExit.put("W", 2);
//        locations.get(5).addExit("Q", 0);
      locations.put(5,new Location(5,"You are in the forest", tempExit));
     */

      Scanner scanner = null;
      try {
          scanner = new Scanner(new FileReader("locations.txt"));
          scanner.useDelimiter(",");
          while(scanner.hasNextLine()) {
              int loc = scanner.nextInt();
              scanner.skip(scanner.delimiter());
              String description = scanner.nextLine();
              System.out.println("imported loc: " + loc + " " + description);
              Map<String, Integer> tempExit = new HashMap<>();
              locations.put(loc, new Location(loc, description, tempExit));

          }

      } catch ( IOException e) {
          e.printStackTrace();
      } finally {
          if (scanner != null) {
              scanner.close();
          }
      }
  }

    @Override
    public int size() {
        return locations.size();
   }

   @Override
   public boolean isEmpty() {
      return locations.isEmpty();
   }

   @Override
   public boolean containsKey(Object key) {
      return locations.containsKey(key);
   }

   @Override
   public boolean containsValue(Object value) {
       return locations.containsValue(value);
   }

   @Override
   public Location get(Object key) {
       return locations.get(key);
   }

   @Override
   public Location put(Integer key, Location value) {
       return locations.put(key, value);
   }

   @Override
   public Location remove(Object key) {
       return locations.remove(key);
   }

   @Override
   public void putAll(Map<? extends Integer, ? extends Location> m) {

   }

   @Override
   public void clear() {

      locations.clear();
   }

   @Override
   public Set<Integer> keySet() {
       return locations.keySet();
   }

   @Override
   public Collection<Location> values() {
       return locations.values();
   }

   @Override
   public Set<Entry<Integer, Location>> entrySet() {
       return locations.entrySet();
   }
}
