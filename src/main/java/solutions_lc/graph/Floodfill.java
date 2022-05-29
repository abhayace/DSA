package solutions_lc.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Floodfill {
        boolean[][] visited;

        private void visited(Pair<Integer,Integer> p){
            visited[p.getKey()][p.getValue()]=true;

        }
        private List<Pair<Integer,Integer>> getUnvisitedNeighbours (Pair<Integer,Integer> curr, Pair<Integer,Integer> lt, Pair<Integer,Integer> rb){
            List<Pair<Integer,Integer>> neighbourList = new ArrayList<>();
            Pair<Integer,Integer> left,top, right, bottom;
            left = curr.getValue()>0 ?new Pair(curr.getKey(),curr.getValue()-1):null;
            right = curr.getValue()<rb.getKey()-1 ?new Pair(curr.getKey(),curr.getValue()+1):null;
            top = curr.getKey()>0?new Pair(curr.getKey()-1,curr.getValue()):null;
            bottom =  curr.getKey()<rb.getValue()-1?new Pair(curr.getKey()+1,curr.getValue()):null;

            if(left!=null && !visited[left.getKey()][left.getValue()]) neighbourList.add(left);
            if(right!=null && !visited[right.getKey()][right.getValue()]) neighbourList.add(right);
            if(top!=null && !visited[top.getKey()][top.getValue()]) neighbourList.add(top);
            if(bottom!=null && !visited[bottom.getKey()][bottom.getValue()]) neighbourList.add(bottom);
            return neighbourList;

        }
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            visited = new boolean[image.length][image[0].length];
            int oldColor = image[sr][sc];
            Pair<Integer,Integer> curr = new Pair(sr,sc);
            Pair lt = new Pair(0,0);
            Pair rb = new Pair(image[0].length, image.length);
            Stack<Pair> stack = new Stack<>();
            stack.push(curr);
            while(!stack.isEmpty()){
                Pair<Integer,Integer> tmp = stack.pop();
                image[tmp.getKey()][tmp.getValue()] = newColor;
                visited(tmp);
                List<Pair> unvisitedNeighbours = getUnvisitedNeighbours(tmp, lt, rb);
                for(Pair<Integer,Integer> p: unvisitedNeighbours){
                    if(image[p.getKey()][p.getValue()] == oldColor)
                        stack.push(p);
                }
            }
            return image;
        }

}
