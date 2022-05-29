package solutions_lc.math;

public class PlusOne {

        public int[] plusOne(int[] digits) {
            int carry = 1;
            for (int i=0; i<digits.length; i++){
                int pos = (digits.length - 1 ) - i;
                if(carry == 0){
                    break;
                }
                else {
                    if (digits[pos] == 9){
                        carry = 1;
                        digits[pos] = 0;
                    }
                    else {
                        digits[pos] = digits[pos] + 1;
                        carry = 0;
                    }
                }
            }
            if (carry == 1){
                int newDigits[] = new int[digits.length+1];
                for (int i=0; i<digits.length; i++){
                    newDigits[i+1]=digits[i];
                }
                newDigits[0]=1;
                digits=newDigits;
            }

            return digits;

        }

}
