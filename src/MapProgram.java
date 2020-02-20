import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        if (languages.containsKey("Java")) {
            System.out.println("Java already exists.");
        } else {
            languages.put("Java", "a complied high level, object-oriented, platform independent language.");
        }
        System.out.println("Java add successfully.");

        for (String key: languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }


    }
}
