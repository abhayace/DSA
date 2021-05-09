package trees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BSTTests {
    private BST<Integer> bst;


    @Test
    @DisplayName("Check insertion if head is null")
    public void insertionWorksWhenHeadIsNull(){
        bst = BST.createBST(new Integer[]{1});
        assertNotNull(bst.getHead());
    }

    @Test
    @DisplayName("Check if larger element is added to the right")
    public void insertionAddsLargerElementToTheRight(){
        bst = BST.createBST(new Integer[]{1});
        bst.insert(4);
        assertEquals(bst.getHead().getRightNode().getValue(), 4);
        assertNull(bst.getHead().getLeftNode());
    }

    @Test
    @DisplayName("If value is not inserted, it should not exist in the tree")
    public void uninsertedValueShouldNotExist(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43});
        assertFalse(bst.valueExists(80));
    }

    @Test
    @DisplayName("If value is inserted, it should exist in the tree")
    public void insertedValueShouldExist(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43});
        assertTrue(bst.valueExists(-43));
    }

    @Test
    @DisplayName("Gets correct parent node")
    public void fetchesCorrectParentNodeIfExists(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43});
        BinaryNode parent = bst.getParent(2);
        assertEquals(6, parent.getValue());
    }

    @Test
    @DisplayName("Deletion for root node is successful")
    public void deletesHeadNodeSuccessfully(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43});
        bst.deleteNode(1);
        assertFalse(bst.valueExists(1));
        System.out.print(bst.getHead());
    }

    @Test
    @DisplayName("Deletion for node is successful")
    public void deletesNonHeadNodeSuccessfully(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43});
        bst.deleteNode(34);
        assertFalse(bst.valueExists(34));
        System.out.print(bst.getHead());
    }

    @Test
    @DisplayName("Recursive Deletion for node is successful")
    public void deletesRecursiveNonHeadNodeSuccessfully(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43});
        bst.deleteNode(34, true);
        assertFalse(bst.valueExists(34));
        System.out.print(bst.getHead());
    }

    @Test
    @DisplayName("Tests if tree is BST")
    public void checkIfTreeISBST(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43});
//        bst.deleteNode(34, true);
        assertTrue(bst.isIntegerBST(bst.getHead()));
    }


    @Test
    @DisplayName("Tests if tree is BST after recursive delete")
    public void checkIfTreeISBSTAfterRecDelete(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43});
        bst.deleteNode(34, true);
        assertTrue(bst.isIntegerBST(bst.getHead()));
    }

    @Test
    @DisplayName("Tests if tree is BST after non recursive delete")
    public void checkIfTreeISBSTAfterNonRecDelete(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43});
        bst.deleteNode(34);
        bst.deleteNode(1);
        bst.deleteNode(6);
        bst.deleteNode(12);

        assertTrue(bst.isIntegerBST(bst.getHead()));
        System.out.print(bst.getHead());

    }

    @Test
    @DisplayName("Tests if delete succeeds for non existent key")
    public void checkIfTreeISBSTAfterInvalidDelete(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43});
        assertThrows(RuntimeException.class, () -> bst.deleteNode(342));
    }

    @Test
    @DisplayName("Finds the lowest common ancestor of two keys")
    public void checkIfLCAIsCorrectForTwoExistingKeys(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43, 48});
        BSTUtils<Integer> bstUtils = new BSTUtils<>(bst);
        Integer key1 = 2;
        Integer key2 = 48;
        Integer expected = 6;
        assertEquals(expected, bstUtils.findLCA(key1, key2));

    }


    @Test
    @DisplayName("Finds the diameter of a given Binary Tree")
    public void checkDiameterForTree(){
        bst = BST.createBST(new Integer[]{1,6,23,2,34,12,-3,-23,-43, 48,-20,-1,24,26,29,11,10,9,8,7,30,31,32,33});
        BSTUtils<Integer> bstUtils = new BSTUtils<>(bst);
        int expectedDiameter = 15;
        assertEquals(expectedDiameter, bstUtils.findDiameter());
    }



}
