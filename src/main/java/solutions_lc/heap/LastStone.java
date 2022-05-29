package solutions_lc.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStone {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(10, Comparator.reverseOrder());
        for(int i: stones){
            queue.add(i);
        }
        System.out.println(queue.poll());
        return 1;
    }
}