package solutions_lc.math;

public class Sqrt_x {
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x<4)
            return 1;
        int st = 1;
        int end = x/2;
        long mid = (long)((st+end)/2);
        while(st<=end){
            mid = (st+end)/2;
            long midsq = (long)(mid*mid);
            if(x < midsq)
                end = (int)mid - 1;
            else {
                // x > midsq
                if ((long)x - midsq >= (2*mid+1))
                    st = (int)mid + 1;
                else
                    break;
            }
        }
        return (int)mid;
    }

    // by newton's method
    public int newtonSqrt(int x) {
        if(x==0) return 0;
        if(x<4)
            return 1;
        long r = x;
        while(r*r > x){
            r = (r + x/r)/2;
        }
        return (int)r;
    }
}
