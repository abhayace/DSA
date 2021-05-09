package trees;


import lombok.Getter;

@Getter
public class BST<T extends Comparable<T>> {

    BinaryNode<T> head;
    int sizeOfTree;


    private BST(){

    }

    public static BST createBST(Comparable[] elements){
        BST b = new BST();
        for (Comparable element: elements){
            b.insert(element);
        }
        return b;
    }

    private BinaryNode insertRecursive (BinaryNode rootNode, T value){

        if (rootNode == null){
            rootNode = new BinaryNode(value);
            return rootNode;
        }
        if (rootNode.getValue().compareTo(value) > 0 ){
            rootNode.setLeftNode(insertRecursive(rootNode.getLeftNode(), value));
        }
        else {
            rootNode.setRightNode(insertRecursive(rootNode.getRightNode(), value));
        }
        return rootNode;
    }

    public void insert(T value){
        this.head = insertRecursive(head, value);
    }

    private BinaryNode lookup(BinaryNode rootNode, T value){
        if (rootNode == null || rootNode.getValue() == value){
            return rootNode;
        }
        if(rootNode.getValue().compareTo(value) > 0){
            return lookup(rootNode.getLeftNode(), value);
        }
        else {
            return lookup(rootNode.getRightNode(), value);
        }
    }


    public BinaryNode getParent(T value) {
        return getParent(this.head, null, value);
    }


    private BinaryNode getParent(BinaryNode<T> rootNode, BinaryNode<T> parent, T value) {
        if (rootNode == null ) {
//            reached the end. no val found
            throw new RuntimeException(String.format("No such key: ", value));
        }
        if(rootNode.getValue() == value){
            return parent;
        }
        if(rootNode.getValue().compareTo(value) > 0){
            return getParent(rootNode.getLeftNode(), rootNode, value);
        }
        else {
            return getParent(rootNode.getRightNode(), rootNode, value);
        }

    }

    public boolean valueExists(T value){
        return lookup(this.head, value) != null;
    }



    private BinaryNode<T> getInorderSuccessor(BinaryNode<T> node){
        if (node.getRightNode() != null){
            BinaryNode tempNode = node.getRightNode();
            while(tempNode.getLeftNode() !=null){
                tempNode = tempNode.getLeftNode();
            }
            return tempNode;
        }
        else
            return null;
    }

    private BinaryNode<T>  getDeletionSuccessor (BinaryNode<T> node){
        if (node.getLeftNode() == null || node.getRightNode() == null){
            if (node.getLeftNode() != null) return node.getLeftNode();
            else return node.getRightNode();
        }
        else {
//            two child case
            BinaryNode<T> successor = getInorderSuccessor(node);
            delete(node, successor.getValue());
            node.setValue(successor.getValue());
            return node;
        }
    }

    public void deleteNode(T value){
        deleteNode(value, false);
    }
   public void deleteNode(T value, boolean isRecursive) {
        if (isRecursive)
            deleteRecursive(this.head, value);
        else
            delete(this.head, value);
    }

    public void delete(BinaryNode<T> head, T value){
        if(this.head ==null){
            throw new RuntimeException("Tree does not exist. Can not delete");
        }
        BinaryNode parent = getParent(head,null, value);
        BinaryNode childToDelete = lookup(head, value);

        if (parent == null){
            this.head = getDeletionSuccessor(childToDelete);
        }
        else{
            if (parent.getRightNode() != null && parent.getRightNode().getValue() == value){
//            Delete right child
                parent.setRightNode(getDeletionSuccessor(childToDelete));
            }
            else {
                parent.setLeftNode(getDeletionSuccessor(childToDelete));
            }
        }


    }


    private BinaryNode<T> deleteRecursive(BinaryNode<T> rootNode, T value){
        if(this.head ==null){
            throw new RuntimeException("Tree does not exist. Can not delete");
        }
        if (rootNode == null) {
            return null;
        }
        T key = rootNode.getValue();
        BinaryNode<T> left = rootNode.getLeftNode();
        BinaryNode<T> right = rootNode.getRightNode();
        if ( key.compareTo(value)>0 ){
            rootNode.setLeftNode(deleteRecursive(left, value));
        }
        else if ( key.compareTo(value) < 0 ){
            rootNode.setRightNode(deleteRecursive(right, value));
        }
        else {
//            key == value, node found
            if ((left == null) && (right == null)){
                return null;
            }
            if (right == null){
                return left;
            }
            else {
                BinaryNode<T> inorderSuccessor = getInorderSuccessor(rootNode);
                deleteRecursive(rootNode, value);
                rootNode.setValue(inorderSuccessor.getValue());
            }

        }

        return rootNode;
    }


    public boolean isIntegerBST (BinaryNode<Integer> head){
        return checkNodeBSTRecursive(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private boolean checkNodeBSTRecursive(BinaryNode<Integer> node, Integer minVal, Integer maxVal){
        if (node == null){
            return true;
        }

        BinaryNode<Integer> left = node.getLeftNode();
        BinaryNode<Integer> right = node.getRightNode();


        if (node.getValue().compareTo(maxVal) > 0 || node.getValue().compareTo(minVal) < 0){
            return false;
        }

        return (
                checkNodeBSTRecursive(left, minVal, node.getValue())
                &&
                checkNodeBSTRecursive(right, node.getValue(), maxVal)
                );

    }

}
