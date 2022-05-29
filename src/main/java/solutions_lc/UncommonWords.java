package solutions_lc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UncommonWords {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Character> uncommonWords = new HashMap<>();
        String[] allWords = (s1 + " " + s2).split(" ");
        for (String word : allWords) {
            if (uncommonWords.containsKey(word)) {
                uncommonWords.put(word, 'm');
            } else uncommonWords.put(word, 's');
        }
        System.out.println(uncommonWords);

        List<String> res = uncommonWords.entrySet().stream().filter(en -> en.getValue() == 's').map(en -> en.getKey()).collect(Collectors.toList());
        return res.toArray(new String[0]);

    }
}
