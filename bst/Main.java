public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(15);
        bst.add(2);
        bst.add(6);
        bst.add(21);
        bst.add(3);
        bst.add(9);
        bst.add(17);
        bst.add(23);
        bst.add(1);

        System.out.println(bst.preOrder());
        System.out.println(bst.inOrder());
        System.out.println(bst.postOrder());

        System.out.println("a".hashCode() + " : " + "b".hashCode());
    }
}
