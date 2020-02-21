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

        languages.put("Python", "a interpreted object-oriented, high-level programming language with dynamic semantics.");
        languages.put("Algol", "an algorithmic language");
        languages.putIfAbsent("Algol", "an     algorithmic language");
        System.out.println("old value: " + languages.put("Algol", "an algorithmic language"));


        languages.put("basic", "Beginners All purposes symbolic Instruction  Code. ");
        languages.put("lisp", "Therein lies madness.");
        System.out.println(languages.get("Java"));

        for (String key: languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }


    }
}
