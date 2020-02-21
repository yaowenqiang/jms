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
        languages.put("Lisp", "Therein lies madness.");
        System.out.println(languages.get("Java"));

        for (String key: languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }

        //languages.remove("Lisp");
        languages.remove("Python");
        if (languages.remove("Algol", "an algorithmic language")) {
            System.out.println("Algol removed.");
        } else {
            System.out.println("Algol not removed, key/value pair not found.");
        }

        System.out.println(languages.replace("Lisp", "a functional programming language with imperative features."));
        System.out.println(languages.replace("Sacla", "This will not be added."));


        if (languages.replace("Lisp", "this will not work", "a functional programming language with imperative features.")) {
            System.out.println("Lisp replaced.");
        } else {
            System.out.println("Lisp not replaced.");
        }



    }
}
