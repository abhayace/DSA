package abh.dsa.math;

import abh.dsa.core.Solution;

import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.util.Scanner;

public class Square10Tree implements Solution {

    Scanner scanner = new Scanner(System.in);



    private void validateArgs(String leftLim, String rightLim, int maxLevel) {
        if (maxLevel < 0){
            throw new RuntimeException();
        }
        if(rightLim=="0" || rightLim.length()<leftLim.length()){
            throw new RuntimeException();
        }

    }

    private double log2(int n){
        return Math.log(n)/Math.log(2);
    }
    private int getMaxLevel(int digits) {
        return (int)Math.ceil(log2(digits));
    }
    private int intervalDigitsAtLevel(int l){
        if (l==0){
            return 1;
        }
        else {
            return (int)(Math.pow(2, l-1)+1);
        }
    }

    @Override
    public void solve() {
        String LS = scanner.nextLine();
        String RS = scanner.nextLine();
        scanner.close();

        System.out.println(String.format("Input: [%s] -> [%s]", LS, RS));

        int maxLevel = getMaxLevel(RS.length());
        System.out.println(String.format("Max Level: %s = %d", RS, maxLevel));
        validateArgs(LS, RS, maxLevel);

        boolean isLastIteration = false;
        int currLevel = 0;
        int endL              = LS.length();
        int endR              = RS.length();
        int blockCount        = 0;
        BigInteger upperBound     = BigInteger.ONE;
        StringBuilder sb = new StringBuilder();
        boolean carry         = false;
        while(!isLastIteration) {
            int numDigits = intervalDigitsAtLevel(currLevel+1) - intervalDigitsAtLevel(currLevel);
            int startL = Math.max(endL-numDigits,0);
            int startR = Math.max(endR-numDigits,0);
            BigInteger numL = (endL==0)?BigInteger.ZERO:new BigInteger(LS.substring(startL, endL));

            if (carry){
                numL = numL.add(BigInteger.ONE);
            }

            if(startR == 0){
                upperBound = new BigInteger(RS.substring(startR, endR));
                isLastIteration=true;
            }
            else
                upperBound = power10BigInt(numDigits);

//          Skip level, else process it
            if((!numL.equals(BigInteger.ZERO) && !numL.equals(upperBound)) || startR==0){
                BigInteger count = upperBound.subtract(numL);
                carry = true;
                blockCount += 1;
                sb.append(String.format("Level %s count %s \n", currLevel, count));
            }
            endL = startL;
            endR = startR;
            currLevel++;

        }

//        Calculate counts for decreasing segment sizes

        StringBuilder sb2 = new StringBuilder();
        currLevel = 0;
        endR = RS.length();

        while (true){
            int numDigits = intervalDigitsAtLevel(currLevel+1) - intervalDigitsAtLevel(currLevel);
            int startR = Math.max(endR - numDigits, 0);
            if (startR == 0) break;

            BigInteger count = new BigInteger(RS.substring(startR, endR));

            if (!count.equals(BigInteger.ZERO)){
                blockCount += 1;
                sb2.insert(0, String.format("Level %s count %s \n", currLevel, count));
            }
            endR = startR;
            currLevel++;

        }

        System.out.println(String.format(" sb1 %s sb2 %s", sb, sb2));



    }

    private BigInteger power10BigInt(int numDigits) {
        byte[] num = new byte[numDigits+1];
        num[0]=1;
        return new BigInteger(num);
    }


}
