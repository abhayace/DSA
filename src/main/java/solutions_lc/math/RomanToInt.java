package solutions_lc.math;

public class RomanToInt {
    private int charToNum(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: {
                System.err.println("Invalid");
                return -1;
            }
        }
    }
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int totalNum = 0;
        for (int i=0; i<chars.length; i++){
            int currNum = charToNum(chars[i]);
            if ((i+1) < chars.length){
                int nextNum =  charToNum(chars[i+1]);
                if(nextNum>currNum){
                    totalNum += nextNum - currNum;
                    i++; //consumed next also
                }
                else{
                    totalNum += currNum;
                }
            }
            else {
                totalNum += currNum;
            }


        }
        return totalNum;

    }
}

