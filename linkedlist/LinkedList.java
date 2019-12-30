public class LinkedList {
    private Node head;
    private int size;


    public LinkedList() {
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this(data, null);
        }

        private Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }
    }
}
