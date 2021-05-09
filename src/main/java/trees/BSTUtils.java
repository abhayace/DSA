package trees;

public class BSTUtils<T extends Comparable<T>> {
    private BST<T> bst;

    public BSTUtils(BST<T> bst){
        this.bst = bst;
    }

    public T findLCA (T key1, T key2){

        BinaryNode<T> tempNode = bst.getHead();
        while (true){
            T val = tempNode.getValue();
            if (val.compareTo(key1) > 0 && val.compareTo(key2) > 0 ){
                tempNode = tempNode.getLeftNode();
                continue;
            }
            if (val.compareTo(key1) < 0 && val.compareTo(key2) < 0 ){
                tempNode = tempNode.getRightNode();
                continue;
            }
            return val;

        }
    }

    public int height(BinaryNode<T> node){
        if(node == null){
            return 0;
        }
        int rightHeight = height(node.getRightNode());
        int leftHeight = height(node.getLeftNode());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int findDiameter() {
        return findDiameterRecursive(bst.getHead());
    }
    private int findDiameterRecursive(BinaryNode<T> node){
        if (node == null){
            return 0;
        }

        int leftHeight = height(node.getLeftNode());
        int rightHeight = height(node.getRightNode());

        int leftDiameter = findDiameterRecursive(node.getLeftNode());
        int rightDiameter = findDiameterRecursive(node.getRightNode());

        return Math.max(Math.max(leftDiameter, rightDiameter), leftHeight+rightHeight+1);

    }


}
