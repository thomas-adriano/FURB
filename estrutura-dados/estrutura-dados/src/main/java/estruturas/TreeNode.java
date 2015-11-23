package estruturas;

/**
 * Created by thomasadriano on 15/04/15.
 */
public class TreeNode<T extends Comparable<T>> {

    private TreeNode left;
    private TreeNode right;
    private final T data;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean isEmpty() {
        return data != null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

}
