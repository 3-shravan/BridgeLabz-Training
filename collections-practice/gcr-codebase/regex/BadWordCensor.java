public class BadWordCensor {

    public static void main(String[] args) {

        String input = "This is a damn bad example with some stupid words.";

        String[] badWords = { "damn", "stupid", "idiot" };
        String regex = "\\b(" + String.join("|", badWords) + ")\\b";

        String output = input.replaceAll("(?i)" + regex, "****");

        System.out.println(output);
    }
}
