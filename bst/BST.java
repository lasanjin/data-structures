import java.util.ArrayList;

public class BST {
    private Node root;
    private boolean addReturn;
    private int deleteReturn;

    public BST() {
        root = null;
    }

    private BST(Node root) {
        this.root = root;
    }

    public BST(int data, BST leftTree, BST rightTree) {
        root = new Node(data);

        if (leftTree != null) {
            root.left = leftTree.root;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        }
    }

    private class Node {
        private Node left, right;
        private int data;

        private Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public String toString() {
            return String.valueOf(data);
        }
    }

    public int find(int target) {
        return find(root, target);
    }

    private int find(Node localRoot, int target) {
        if (localRoot == null) {
            return Integer.MIN_VALUE;
        }
        if (localRoot.data == target) {
            return localRoot.data;

        } else if (target < localRoot.data) {
            return find(localRoot.left, target);

        } else {
            return find(localRoot.right, target);
        }
    }

    public boolean add(int insert) {
        root = add(root, insert);
        return addReturn;
    }

    private Node add(Node localRoot, int insert) {
        if (localRoot == null) {
            addReturn = true;
            return new Node(insert);

        } else if (insert == localRoot.data) {
            addReturn = false;
            return localRoot;

        } else if (insert < localRoot.data) {
            localRoot.left = add(localRoot.left, insert);
            return localRoot;

        } else {
            localRoot.right = add(localRoot.right, insert);
            return localRoot;
        }
    }

    public int delete(int target) {
        root = delete(root, target);
        return deleteReturn;
    }

    private Node delete(Node localRoot, int target) {
        if (localRoot == null) {
            deleteReturn = Integer.MIN_VALUE;
            return localRoot;
        }

        if (target < localRoot.data) {
            localRoot.left = delete(localRoot.left, target);
            return localRoot;

        } else if (target > localRoot.data) {
            localRoot.right = delete(localRoot.right, target);
            return localRoot;

        } else {

            deleteReturn = localRoot.data;

            if (localRoot.left == null) {
                return localRoot.right;

            } else if (localRoot.right == null) {
                return localRoot.left;

            } else {

                if (localRoot.left.right == null) {
                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                    return localRoot;

                } else {
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    private int findLargestChild(Node parent) {
        if (parent.right.right == null) {
            int temp = parent.right.data;
            parent.right = parent.right.left;
            return temp;
        } else {
            return findLargestChild(parent.right);
        }
    }

    public int getData() {
        return !isEmpty() ? root.data : -1;
    }

    public BST getLeftSubtree() {
        if (!isEmpty() && root.left != null) {
            return new BST(root.left);
        }
        return null;
    }

    public BST getRightSubtree() {
        if (!isEmpty() && root.right != null) {
            return new BST(root.right);
        }
        return null;
    }

    public boolean isLeaf() {
        return !isEmpty()
                && root.left == null
                && root.right == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void preOrderTraverse(Node node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append(". ");
        }
        if (node == null) {
            sb.append("∞\n");
            return;
        }
        sb.append(node.toString()).append("\n");
        preOrderTraverse(node.left, depth + 1, sb);
        preOrderTraverse(node.right, depth + 1, sb);
    }

    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb.append("[ "));
        return sb.append("]").toString();
    }

    private void postOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.toString()).append(" ");
    }

    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb.append("[ "));
        return sb.append("]").toString();
    }

    private void inOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrder(node.left, sb);
        sb.append(node.toString()).append(" ");
        inOrder(node.right, sb);
    }

    public String preOrder() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb.append("[ "));
        return sb.append("]").toString();
    }

    private void preOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.toString()).append(" ");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    public int nNode() {
        return nNode(root);
    }

    private int nNode(Node localRoot) {
        if (localRoot == null) {
            return 0;
        }
        return 1 + nNode(localRoot.left) + nNode(localRoot.right);
    }
}
