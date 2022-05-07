package solutions_lc.math;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PallindromicNumber {
    public boolean isPalindromeLowSpace(int x) {

        if(x<0)
            return false;
        int tmp = 0;
        int num=1;
        while(x/num > 0){
            int currUnit = (x % (10*num))/num;
            tmp = (tmp*10) + currUnit;
            num *= 10;
        }
        return tmp == x;

    }

    public boolean isPalindrome(int x) {

        if(x<0)
            return false;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();

        while(x>0){
            int currUnitPlace = x%10;
            queue.offer(currUnitPlace);
            stk.push(currUnitPlace);
            x/=10;
        }
        while (!stk.isEmpty()){
            if(stk.pop()!=queue.remove()){
                return false;
            }
        }
        return true;
    }
}
