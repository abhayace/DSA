package solutions_lc.graph;

import java.util.Stack;

public class Islands {
    public int numIslands(char[][] grid) {
        Stack<int[]> stack ;
        int numIslands=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]!='1') continue;
                stack = new Stack();
                stack.push(new int[]{i,j});
                while(!stack.empty()){
                    int[] curr  = stack.pop();
                    grid[curr[0]][curr[1]] = 'v';

                    if(curr[0]>0 && grid[curr[0]-1][curr[1]]=='1'){
                        stack.push(new int[]{curr[0]-1,curr[1]});
                    }
                    if(curr[1]>0 && grid[curr[0]][curr[1]-1]=='1'){
                        stack.push(new int[]{curr[0],curr[1]-1});
                    }
                    if((curr[0]<grid.length-1) && (grid[curr[0]+1][curr[1]]=='1')){
                        stack.push(new int[]{curr[0]+1,curr[1]});
                    }
                    if((curr[1]<grid[0].length-1) && (grid[curr[0]][curr[1]+1]=='1')) {
                        stack.push(new int[]{curr[0],curr[1]+1});
                    }
                }
                numIslands++;
            }
        }
        return numIslands;
    }
}
