package solutions_lc.string;

public class WordAsPrefix {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int idx=1;
        for (String word: sentence.split(" ")){
            if(word.startsWith(searchWord))
                return idx;
            idx++;
        }
        return -1;
    }
}
