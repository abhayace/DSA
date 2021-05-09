package heaps;

public class HeapUtils {

    public int numHeaps (int numElements) {
        int MAXN = 105;
        int[] memory = new int[MAXN];
        int[][] ncr = new int[MAXN][MAXN];
        int[] log2 = new int[MAXN];

        class NumHeapCalculator {
            int N;
            NumHeapCalculator(int N){
                this.N = N;
                init();
            }

            void init(){
                for (int i=0;i<=this.N;i++)
                    memory[i]=-1;

                for (int i=0;i<=this.N;i++){
                    for (int j=0;j<=this.N; j++){
                        ncr[i][j] = -1;
                    }
                }
                int currLog2 = -1;
                int currPower2 = 1;
                for (int i=1; i<=this.N; i++){

                    if (currPower2 == i){
                        currLog2++;
                        currPower2 *= 2;
                    }
                    log2[i]= currLog2;
                }
            }

            //return nCr
            int choose(int N, int r) {
                if (r>N)
                    return 0;

                if (N <= 1)
                    return 1;

                if (r==0)
                    return 1;

                if (ncr[N][r] != -1){
                    return ncr[N][r];
                }

                int ans = choose(N-1, r-1) + choose(N-1, r);
                ncr[N][r]=ans;
                return ans;

            }

            int getNumElemsInLeft(int totalElements){
                if (totalElements==1)
                    return 0;
                int height = log2[totalElements];

                int hLevelElems = 1<<height;

                int lastLevelElems = totalElements - ((1<<height)-1);

                if (lastLevelElems >= hLevelElems/2)
                    return (1<<height)-1;
                else
                    return (1<<height)-1 - ((hLevelElems/2) - lastLevelElems);
            }

            int getNumHeapsRec(int n){
                if (n <=2)
                    return 1;
                if(memory[n]!=-1){
                    return memory[n];
                }
                int numElementsInLeft = getNumElemsInLeft(n);
                int numElementsInRight = (n-1)-numElementsInLeft;
                int answer = choose(n-1, numElementsInLeft)*getNumHeapsRec(numElementsInLeft)*getNumHeapsRec(numElementsInRight);

                return answer;
            }
            int getNumHeaps(){
                return getNumHeapsRec(this.N);

            }

        }
        NumHeapCalculator nhp = new NumHeapCalculator(numElements);
        return nhp.getNumHeaps();

    }

}
