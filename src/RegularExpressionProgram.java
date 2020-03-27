public class RegularExpressionProgram {
    public static void main(String[] args) {
        String string = "I am a string? yes I am";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcddee222kljfkjsfljskldafjds99b";
        System.out.println(alphanumeric.replaceAll(".", "y"));

        System.out.println(alphanumeric.replaceAll("^abcddee","YYY"));

        String secondString = "abcdDeeabcddeeabcdDee222kljfkjsfljskldafjds99b";
        System.out.println(secondString.replaceAll("^abcdDee", "YYY"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcdDee"));
        System.out.println(alphanumeric.matches("^abcddee222kljfkjsfljskldfjds99b"));
        System.out.println(alphanumeric.replaceAll("jds99b$"," THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]"," X"));
        System.out.println(alphanumeric.replaceAll("[aei]"," I replace a letter here"));
        System.out.println(alphanumeric.replaceAll("[aei][fj]","X"));

    }
}
