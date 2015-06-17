package estruturas;

import apple.laf.JRSUIUtils;

/**
 * Created by thomasadriano on 15/04/15.
 * <p/>
 * <p/>
 * 85
 * 69             110
 * 49/  \70       95/   \120
 * 23/  \55        88/
 * <p/>
 * pré-fixado: 85, 69, 49, 23, 55, 70, 110, 95, 88, 120
 * central:    23, 49, 55, 69, 70, 85, 88, 95, 110, 120
 * pós-fixado:
 */
public class BinaryTree<T extends Comparable<T>> {

    public static interface Action<T extends Comparable<T>> {
        void apply(TreeNode<T> node);
    }

    private TreeNode root;
    private int size;

    private void add(T data) {
        if (root == null) {
            this.root = new TreeNode(data);
        } else {
            addAux(root, new TreeNode<T>(data));
        }
    }

    private void addAux(TreeNode<T> node, TreeNode<T> toInsert) {
        if (toInsert.getData().compareTo(node.getData()) <= 0) {
            if (!node.hasLeft()) {
                node.setLeft(toInsert);
                size++;
            } else {
                addAux(node.getLeft(), toInsert);
            }

        } else {
            if (!node.hasRight()) {
                node.setRight(toInsert);
                size++;
            } else {
                addAux(node.getRight(), toInsert);
            }
        }
    }


    public void walkInfixed(Action<T> action) {
        if (root == null) {
            return;
        }

        if (root.hasLeft()) {
            walkInfixedAux(root.getLeft(), action);
        }

        action.apply(root);

        if (root.hasRight()) {
            walkInfixedAux(root.getRight(), action);
        }
    }

    private void walkInfixedAux(TreeNode<T> actual, Action<T> action) {
        if (actual.hasLeft()) {
            walkPrefixedAux(actual.getLeft(), action);
        }

        action.apply(actual);

        if (actual.hasRight()) {
            walkPrefixedAux(actual.getRight(), action);
        }
    }

    public void walkPrefixed(Action<T> action) {
        if (root == null) {
            return;
        }

        action.apply(root);

        if (root.hasLeft()) {
            walkPrefixedAux(root.getLeft(), action);
        }

        if (root.hasRight()) {
            walkPrefixedAux(root.getRight(), action);
        }
    }

    private void walkPrefixedAux(TreeNode<T> actual, Action<T> action) {
        action.apply(actual);

        if (actual.hasLeft()) {
            walkPrefixedAux(actual.getLeft(), action);
        }

        if (actual.hasRight()) {
            walkPrefixedAux(actual.getRight(), action);
        }
    }

    public void walkPostfixed(Action<T> action) {
        if (root == null) {
            return;
        }

        if (root.hasLeft()) {
            walkPrefixedAux(root.getLeft(), action);
        }

        if (root.hasRight()) {
            walkPrefixedAux(root.getRight(), action);
        }
        action.apply(root);
    }

    private void walkPostfixedAux(TreeNode<T> actual, Action<T> action) {

        if (actual.hasLeft()) {
            walkPostfixedAux(actual.getLeft(), action);
        }

        if (actual.hasRight()) {
            walkPostfixedAux(actual.getRight(), action);
        }
        action.apply(actual);
    }

    public int maxLevel() {
        int right = 0;
        int left = 0;
        if (root != null) {
            if (root.hasRight()) {
                right = maxLevelRight(root.getRight());
                right++;
            }

            if (root.hasLeft()) {
                left = maxLevelLeft(root.getLeft());
                left++;
            }
        }

        return right > left ? right : left;
    }

    private int maxLevelRight(TreeNode<T> node) {
        int result = 1;
        if (node.hasRight()) {
            result = maxLevelRight(node.getRight());
            result++;
            return result;
        } else return result;
    }

    private int maxLevelLeft(TreeNode<T> node) {
        int result = 1;
        if (node.hasLeft()) {
            result = maxLevelLeft(node.getLeft());
            result++;
            return result;
        } else return result;
    }

    public int size() {
        int result = 0;
        if (root != null) {
            if (root.hasRight()) {
                result = size(root.getRight(), result);
            }

            if (root.hasLeft()) {
                result = size(root.getLeft(), result);
            }
        }

        return ++result;
    }

    private int size(TreeNode<T> node, int count) {
        if (node.hasRight()) {
            count = size(node.getRight(), count);
        }
        if (node.hasLeft()) {
            count = size(node.getLeft(), count);
        }
        return ++count;
    }

    private int totalLeafs() {
        int result = 0;
        if (root != null) {
            if (root.hasRight()) {
                result = totalLeafs(root.getRight(), result);
            }

            if (root.hasLeft()) {
                result = totalLeafs(root.getLeft(), result);
            }

            if (!root.hasLeft() && !root.hasRight()) {
                result++;
            }
        }

        return result;
    }

    private int totalLeafs(TreeNode<T> node, int count) {
        if (!node.hasLeft() && !node.hasRight()) {
            return ++count;
        }

        if (node.hasRight()) {
            count = totalLeafs(node.getRight(), count);
        }

        if (node.hasLeft()) {
            count = totalLeafs(node.getLeft(), count);
        }

        return count;
    }

    public boolean isEqual(BinaryTree<T> tree) {
        boolean result = false;
        if (root != null && tree.root != null) {
            if (root.getData() != tree.root.getData()) {
                return false;
            }

            if (root.hasRight() && tree.root.hasRight()) {
                result = isEqual(root.getRight(), tree.root.getRight());
            } else {
                if (!root.hasRight() && !tree.root.hasRight()) {
                    result = true;
                }
                return false;
            }

            if (root.hasLeft() && tree.root.hasLeft()) {
                result &= isEqual(root.getLeft(), tree.root.getLeft());
            } else {
                if (!root.hasLeft() && !tree.root.hasLeft()) {
                    result &= true;
                }
                return false;
            }
        }

        if (root == null & tree.root == null) {
            return true;
        }


        return result;
    }

    private boolean isEqual(TreeNode<T> first, TreeNode<T> second) {
        boolean result = true;

        if (first.getData() != second.getData()) {
            return false;
        } else {
            if (first.hasRight() && second.hasRight()) {
                result = isEqual(first.getRight(), second.getRight());
            } else {
                if (!(!first.hasRight() && !second.hasRight())) {
                    return false;
                }
            }

            if (first.hasLeft() && second.hasLeft()) {
                result &= isEqual(first.getLeft(), second.getLeft());
            } else {
                if (!(!first.hasLeft() && !second.hasLeft())) {
                    return false;
                }
            }

            return result;
        }
    }

    public BinaryTree<T> copyOf(BinaryTree<T> anotherTree) {
        BinaryTree<T> result = new BinaryTree<>();
        if (anotherTree.root != null) {
            TreeNode<T> r = new TreeNode<>((T) anotherTree.root.getData());
            this.root = r;

            copy(anotherTree.root.getRight(), anotherTree.root.getLeft(), root);
        }
        return result;
    }

    private void copy(TreeNode<T> rightNode, TreeNode<T> leftNode, TreeNode<T> thisPrevious) {
        if (rightNode != null) {
            TreeNode<T> newNode = new TreeNode<>((T) rightNode.getData());
            thisPrevious.setRight(newNode);
        }

        if (leftNode != null) {
            TreeNode<T> newNode = new TreeNode<>((T) leftNode.getData());
            thisPrevious.setLeft(newNode);
        }

        if (rightNode != null) {
            copy(rightNode.getRight(), rightNode.getLeft(), thisPrevious.getRight());
        }

        if (leftNode != null) {
            copy(leftNode.getRight(), leftNode.getLeft(), thisPrevious.getLeft());
        }
    }

    public boolean removeNode(T data) {
        //nó a ser removido tem:
        //0 filhos
        //1 filho
        //2 filhos
        //2 filhos e algum deles com 1 filho
        //2 filhos e ambos com 2 filhos

        if (root != null) {
            manipulateNodeExclusion(null, root, data, false);
        }


        return false;
    }

    private void manipulateNodeExclusion(TreeNode<T> parent, TreeNode<T> node, T data, boolean isRight) {
        if (node != null && node.getData().compareTo(data) == 0) {
            if (!node.hasLeft() && !node.hasRight()) {
                //se o nó não possuir nenhum filho
                assign(parent, null, isRight);
            } else if (!node.hasLeft()) {
                //se o nó possuir apenas um filho (o da direita)...
                TreeNode<T> rightNode = node.getRight();
                node.setRight(null);

                assign(parent, rightNode, isRight);
            } else if (!node.hasRight()) {
                //se o nó possuir apenas um filho (o da esquerda)...
                TreeNode<T> leftNode = node.getLeft();
                node.setLeft(null);

                assign(parent, leftNode, isRight);
            } else {
                //se o nó possuir ambos os filhos..
                TreeNode<T> choosedChild = getSubtreeWithoutBadSituation(node);
                if (choosedChild != null) {
                    //se o nó possuir ambos os filhos e um deles tiver apenas um filho do lado oposto...
                    if (choosedChild.getData().compareTo((T) node.getData()) > 0) {
                        //situação acima no lado direito
                        TreeNode<T> leftSideTreeNode = node.getLeft();
                        node.setLeft(null);
                        node.setRight(null);
                        choosedChild.setLeft(leftSideTreeNode);

                        assign(parent, choosedChild, isRight);

                    } else {
                        //situação acima no lado esquerdo
                        TreeNode<T> rightSideTreenode = node.getRight();
                        node.setLeft(null);
                        node.setRight(null);
                        choosedChild.setRight(rightSideTreenode);

                        assign(parent, choosedChild, isRight);
                    }
                } else {
                    //se o nó possuir ambos os filhos e eles possuirem ambos os filhos

                    //1 pega o nó a direita
                    //2 pega o filho da esquerda do nó da direita
                    //3 atribui como filho da ultima folha a direita do nó da esquerda o nó do passo 2
                    //4 atribui null para o filho a esquerda do nó do passo 1
                    //5 atribui o nó do passo 1 como raiz da árvore

                    TreeNode<T> rightSubTree = node.getRight();
                    TreeNode<T> rightNodeLeftChild = rightSubTree.getLeft();
                    TreeNode<T> leftSubTree = node.getLeft();

                    TreeNode<T> leftNode = leftSubTree;
                    while (leftNode != null) {
                        if (leftNode.hasRight()) {
                            leftNode = leftNode.getRight();
                        } else {
                            leftNode.setRight(rightNodeLeftChild);
                        }
                    }

                    rightSubTree.setLeft(leftSubTree);
                    assign(parent, rightSubTree, isRight);
                }
            }
        } else if (node != null) {
            manipulateNodeExclusion(node, node.getLeft(), data, false);
            manipulateNodeExclusion(node, node.getRight(), data, true);
        }
    }

    private void assign(TreeNode<T> parent, TreeNode<T> target, boolean isRight) {
        if (parent == null) {
            root = target;
        } else {
            if (isRight) {
                parent.setRight(target);
            } else {
                parent.setLeft(target);
            }
        }
    }

    private TreeNode<T> getSubtreeWithoutBadSituation(TreeNode<T> node) {
        TreeNode<T> parent = node;
        if (node.hasLeft()) {
            node = node.getLeft();
            if (!node.hasRight()) {
                return node;
            }
        }

        node = parent;
        if (node.hasRight()) {
            node = node.getRight();
            if (!node.hasLeft()) {
                return node;
            }
        }

        return null;
    }

    private TreeNode<T> getSubtreeWithoutBothChilds(TreeNode<T> node) {
        boolean left = false;
        boolean right = false;

        TreeNode<T> grandFather = node;
        if (node.hasLeft()) {
            node = node.getLeft();
            if (!node.hasLeft() || !node.hasRight()) {
                return node;
            }
        }

        node = grandFather;
        if (node.hasRight()) {
            node = node.getRight();
            if (!node.hasLeft() || !node.hasRight()) {
                return node;
            }
        }

        return null;
    }

    public void rotateRight() {

    }

    public void rotateLeft() {

    }

    //                    85
    //               69       110
    //           49     70 95     120
    //        23         88

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(85);
        tree.add(69);
        tree.add(110);
        tree.add(49);
        tree.add(70);
        tree.add(95);
        tree.add(120);
        tree.add(88);
        tree.add(23);

//        BinaryTree<Integer> tree2 = new BinaryTree<>();
//        tree2.add(85);
//        tree2.add(69);
//        tree2.add(110);
//        tree2.add(49);
//        tree2.add(70);
//        tree2.add(95);
//        tree2.add(120);
//        tree2.add(88);
//        tree2.add(23);

//        System.out.println("MaxLevel: " + tree.maxLevel());
//        System.out.println("Size: " + tree.size());
//        System.out.println("Total leafs: " + tree.totalLeafs());
//        System.out.println("isEqual: " + tree.isEqual(tree2));
//
//
//        System.out.println("copying... ");
//        BinaryTree<Integer> copiedTree = new BinaryTree<>();
//        copiedTree.copyOf(tree);
//
//        System.out.println("Copied tree equals? " + copiedTree.isEqual(tree));

        tree.walkPrefixed(new Action<Integer>() {
            @Override
            public void apply(TreeNode<Integer> node) {
                System.out.println(node.getData());
            }
        });

        System.out.println("=================================================");
        tree.walkInfixed(new Action<Integer>() {
            @Override
            public void apply(TreeNode<Integer> node) {
                System.out.println(node.getData());
            }
        });

        System.out.println("=================================================");
        tree.walkPostfixed(new Action<Integer>() {
            @Override
            public void apply(TreeNode<Integer> node) {
                System.out.println(node.getData());
            }
        });
//        tree.removeNode(110);

//        System.out.println("###################################");
//        tree.walkPrefixed(new Action<Integer>() {
//            @Override
//            public void apply(TreeNode<Integer> node) {
//                System.out.println(node.getData());
//            }
//        });
    }

}
