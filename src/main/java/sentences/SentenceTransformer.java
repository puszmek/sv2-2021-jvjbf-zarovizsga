package sentences;

public class SentenceTransformer {

    public static final String ENDS = ".!?";

    public String shortenSentence(String sentence) {
        isValidSentence(sentence);
        String[] parts = sentence.split(" ");
        if (parts.length < 5) {
            return sentence;
        } else {
            return new StringBuilder(parts[0]).append(" ... ").append(parts[parts.length - 1]).toString();
        }
    }

    private boolean isValidSentence(String sentence) {
        return isValidStarting(sentence) && isValidEnding(sentence);
    }

    private boolean isValidStarting(String sentence) {
        if (sentence.charAt(0) == sentence.toUpperCase().charAt(0)) {
            return true;
        } else {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
    }

    private boolean isValidEnding(String sentence) {
        if (ENDS.contains("" + sentence.charAt(sentence.length() - 1))) {
            return true;
        } else {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }

}
