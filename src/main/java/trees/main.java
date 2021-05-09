package trees;

public class main {

    public static void main(String[] arg){
        BST<Integer> tree = BST.createBST(new Integer[]{10,4,30,23,53,66});
        System.out.print(tree.getHead());
    }
}
