package sentences;

public class SentenceTransformer {

    public String shortenSentence(String sentence) {
        validateSentenceFirstCharAndLastChar(sentence);
        String[] parts = sentence.split(" ");
        if (parts.length < 5) {
            return sentence;
        } else {
            return parts[0] + " ... " + parts[parts.length - 1];
        }
    }

    private void validateSentenceFirstCharAndLastChar(String sentence) {
        char firstChar = sentence.charAt(0);
        char lastChar = sentence.charAt(sentence.length() - 1);
        if (Character.isLowerCase(firstChar)) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
        if (!(lastChar == '.' || lastChar == '!' || lastChar == '?')) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }
}
