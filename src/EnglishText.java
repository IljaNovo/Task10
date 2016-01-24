import java.util.*;

public class EnglishText {

    private String text;

    public EnglishText(String text) {
        if (text == null) {
            text = " ";
        }
        this.text = text;
    }

    public Set<String> findUniqWords() {
        HashSet<String> uniqWords = new HashSet<>();
        String[] words = text.split(" ");

        if (words.length == 0 ||
                (words.length == 1 && words[0] == "")) {
            return uniqWords;
        }

        for(String item : words) {
            if (!checkBelongs(uniqWords, item)) {
                uniqWords.add(item);
            }
        }
        return uniqWords;
    }

    private Integer searchFrequencyWord(List<String> wordsOfText, String str) {
        char[] wordUpperCase = str.toCharArray();
        char[] wordLowerCase = str.toCharArray();

        wordLowerCase[0] = Character.toLowerCase(wordLowerCase[0]);
        wordUpperCase[0] = Character.toUpperCase(wordUpperCase[0]);

        return  Collections.frequency(wordsOfText, new String(wordLowerCase)) +
                Collections.frequency(wordsOfText, new String(wordUpperCase));
    }

    public Map<String, Integer> frequency() {
        HashMap<String, Integer> frequencyWords = new HashMap<>();
        Set<String> uniqWords = findUniqWords();
        List<String> wordsOfText = Arrays.asList(text.split(" "));

        for (String item : uniqWords) {
            frequencyWords.put(item, searchFrequencyWord(wordsOfText, item));
        }
        return frequencyWords;
    }

    private boolean checkBelongs(Set<String> uniqWords, String str) {
        char[] wordUpperCase = str.toCharArray();
        char[] wordLowerCase = str.toCharArray();

        wordLowerCase[0] = Character.toLowerCase(wordLowerCase[0]);
        wordUpperCase[0] = Character.toUpperCase(wordUpperCase[0]);

        if (uniqWords.contains(new String(wordLowerCase)) ||
                uniqWords.contains(new String(wordUpperCase))) {
            return true;
        }
        else {
            return false;
        }
    }
}
