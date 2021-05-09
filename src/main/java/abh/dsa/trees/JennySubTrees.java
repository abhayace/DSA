package abh.dsa.trees;

import abh.dsa.core.Solution;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JennySubTrees implements Solution {


    private final int NMAX = 50000 + 5;
    private List<Integer>[] tree;
    private List<Integer>[] graph;

    private Pair<Integer, Integer>[] hs;


    private int[] powC1 = new int[2 * NMAX];
    private int[] powC2 = new int[2 * NMAX];

    final int MOD1 = 1000000000 + 7;
    final int MOD2 = 1000000000 + 21;
    final int C1 = 633;
    final int C2 = 67;

    private void initPOW(int n) {
        powC1[0] = powC2[0] = 1;
        for (int i=1; i<=(2*n); i++){
            powC1[i] = (1 * C1 * powC1[i-1])%MOD1;
            powC2[i] = (1 * C2 * powC2[i-1])%MOD2;
        }
    }

    private void initArr(List[] arr, int n){
        for(int i=0;i<n;i++){
            arr[i]=new ArrayList<Integer>();
        }
    }

    @Override
    public void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();


        tree = new List[n + 1];
        graph = new List[n + 1];


        initPOW(n);

        initArr(tree, n);
        initArr(graph, n);


        for (int edgeCtr = 0; edgeCtr < n - 1; edgeCtr++) {
            int from = in.nextInt();
            int to = in.nextInt();
            graph[from].add(to);
            graph[to].add(from);
        }


    }
}
