import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
//https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
//https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

public class StreamProgram {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40",
                "N36",
                "B12",
                "B16",
                "J53",
                "J49",
                "J60",
                "J50",
                "j64",
                "I20",
                "I70",
                "29",
                "O71"
        );

        List<String> jNumbers = new ArrayList<>();


//        someBingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("J")) {
//                jNumbers.add(number);
//            }
//        });
//
//        jNumbers.sort((String s1, String s2) -> s1.compareTo(s2) );
//        jNumbers.forEach((String s) -> System.out.println(s)) ;

        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
//                .map(s -> s.toUpperCase())
                .filter(s -> s.startsWith("J"))
                .sorted()
                .forEach(System.out::println);

//        String upperString = myString.toUpperCase();
//        String upperString = toUppercase(myString);
//        List.forEachI(System.out.println);
//        (String s) -> System.out.println(s);
//        Class::method


        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");

        Stream<String> inNumberStream = Stream.of("N40", "N36", "I60", "I70", "I29", "O71");

        Stream<String> concatString = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("----------------");
        System.out.println(concatString
                .distinct()
                .peek(System.out::println)
                .count());

        MyEmployee jone = new MyEmployee("John", 20);
        MyEmployee jack = new MyEmployee("Jack", 29);
        MyEmployee jame = new MyEmployee("Jame", 40);
        MyEmployee jimmy = new MyEmployee("Jimmy", 52);
        MyEmployee carl = new MyEmployee("Carl", 24);

        Department hr = new Department("human Resources");
        hr.addEmployee(jone);
        hr.addEmployee(jack);
        hr.addEmployee(jame);
        hr.addEmployee(jimmy);

        Department counting = new Department("Accounting");
        counting.addEmployee(carl);

        List<Department> departments = new ArrayList<>();

        departments.add(hr);
        departments.add(counting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
    }

}
