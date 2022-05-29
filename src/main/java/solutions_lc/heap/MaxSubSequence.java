package solutions_lc.heap;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxSubSequence {

    public int[] maxSubsequence(int[] nums, int k) {
        Queue<Pair<Integer,Integer>> queue = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
        Queue<Pair<Integer,Integer>> queue2 = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        for(int i=0;i<nums.length;i++)
            queue.add(new Pair<>(i,nums[i]));
        int sum=0;
        while(k>0){
            queue2.add(queue.poll());
            k--;
        }
        int[] res = new int[k];
        int i=0;
        while(!queue2.isEmpty())
            res[i++]=queue2.poll().getValue();
        return res;

    }
}
