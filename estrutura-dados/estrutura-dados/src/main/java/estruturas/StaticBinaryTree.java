package estruturas;

/**
 * Created by thomasadriano on 27/04/15.
 */
public class StaticBinaryTree<T extends Comparable<T>> {
    private T[] items;
    private int rightNode = 2;
    private int leftNode = 1;
    private int thisNode = 0;
    private static final int MIN_LEFT_JUMP = 1;
    private static final int MIN_RIGHT_JUMP = 2;
    private static final int MAX_LEFT_JUMP = 2;
    private static final int MAX_RIGHT_JUMP = 3;

    public StaticBinaryTree(T[] items) {
        this.items = items;
    }

    private void add(T node) {
        if (items[thisNode] == null) {
            items[thisNode] = node;
        } else {
            if (items[thisNode].compareTo(node) < 0) {
                add(node, rightNode, false);
            } else {
                add(node, leftNode, true);
            }
        }
    }

    private void add(T node, int index, boolean isLeft) {
        if (items[index] == null) {
            items[index] = node;
        } else {
            if (items[index].compareTo(node) >= 0) {
                if (isLeft) {
                    add(node, index + MAX_LEFT_JUMP, true);
                } else {
                    add(node, index + MIN_LEFT_JUMP, true);
                }
            } else {
                if (isLeft) {
                    add(node, index + MAX_RIGHT_JUMP, false);
                } else {
                    add(node, index + MIN_RIGHT_JUMP, false);
                }
            }

        }
    }

    public static void main(String[] args) {
        StaticBinaryTree<Integer> staticTree = new StaticBinaryTree<>(new Integer[8]);
        staticTree.add(10);
        staticTree.add(22);
        staticTree.add(18);
        staticTree.add(24);
        staticTree.add(16);
        staticTree.add(50);
        staticTree.add(76);
        staticTree.add(44);


        System.out.println("dsa");
    }

}
