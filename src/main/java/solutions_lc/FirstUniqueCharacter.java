package solutions_lc;

class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[27];

        //init
        for (int i=0;i<27;i++)
            map[i]=0;
        int i=0;
        for (char c: s.toCharArray()){
            int val = map[(int)(c-'a')];
            if (val == 0){
                map[(int)(c-'a')] = i+1;
            }
            if (val>0){
                map[(int)(c-'a')] *=-1;
            }
            i++;
            //do nothing. Already seen multiple times.
        }
        ;
        int minIndex = Integer.MAX_VALUE -1 ;
        for (i=0;i<27;i++){
            minIndex = map[i]>0 && map[i]<minIndex ? map[i] : minIndex;
        }
        return minIndex == Integer.MAX_VALUE -1 ? -1 : minIndex-1;
    }

}
