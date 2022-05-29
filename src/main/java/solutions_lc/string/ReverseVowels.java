package solutions_lc.string;

import java.util.Locale;

public class ReverseVowels {
    private boolean isVowel (char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
    public String reverseVowels(String s) {
        String temp = s.toLowerCase();
        char[] res = s.toCharArray();
        int beg = 0;
        int end = s.length()-1;
        while( beg < end ) {
            if(isVowel(temp.charAt(beg))){
//                find corresponding end
                while((end >beg) && (!isVowel(temp.charAt(end)))) {
                    end--;
                }
                if(end>beg){
                    char tmp = s.charAt(beg);
                    res[beg] = s.charAt(end);
                    res[end] = tmp;
                }
            }
            beg++;
        }
        return new String(res);
    }
}
