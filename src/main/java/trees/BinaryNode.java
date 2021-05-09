package trees;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = true)
public class BinaryNode<T extends Comparable> {
    T value;
    BinaryNode<T> leftNode;
    BinaryNode<T> rightNode;

    public BinaryNode(T value){
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }


}
