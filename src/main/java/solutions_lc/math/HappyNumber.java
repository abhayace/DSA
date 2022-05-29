package solutions_lc.math;

public class HappyNumber {
//    Copied from a discssion
//     LL cycle detection

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = square(slow);
            fast = square(square(fast));
            if(slow == 1)
                return true;
        }while(slow!=fast);
        return false;
    }

    private int square(int num){
        int newNum = 0;
        while(num > 0){
            newNum += Math.pow(num%10, 2);
            num/=10;
        }
        return newNum;
    }
}
