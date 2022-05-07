package solutions_lc;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    Queue<Integer> queue ;
    public RecentCounter() {
        queue  = new LinkedList<>();
    }

    public int ping(int t) {
        int earliestPing = queue.size()>0 ? queue.peek(): 0;
        queue.offer(t);
        while (t - queue.peek() > 3000)
            queue.poll();
        return queue.size();
    }
}
