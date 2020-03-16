import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

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
                .filter(s -> s.startsWith("J"))
                .sorted()
                .forEach(System.out::println);





    }

}
