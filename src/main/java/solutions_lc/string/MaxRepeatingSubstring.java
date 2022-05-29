package solutions_lc.string;

public class MaxRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        int beg = 0;
        String wordToFind = word;
        int count =0;

        while(true){
            int wordBeg = sequence.substring(beg).indexOf(wordToFind);
            if(wordBeg == -1){
                return count;
            }
            else {
                count++;
                wordToFind+=word;
                beg=wordBeg;
            }
        }
    }
}
