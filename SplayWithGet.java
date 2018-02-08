public class SplayWithGet<E extends Comparable<? super E>>
        extends BinarySearchTree<E>
        implements CollectionWithGet<E> {

    public SplayWithGet() {

    }

    /* Rotera 1 steg i hogervarv:
            x'                 y'
           / \                / \
          y'  C   -->        A   x'
         / \                    / \
        A   B                  B   C
    */
    private void zig(Entry x) {
        Entry y = x.left;
        E temp = x.element;
        x.element = y.element;
        y.element = temp;
        x.left = y.left;

        if (x.left != null) {
            x.left.parent = x;
        }
        y.left = y.right;
        y.right = x.right;

        if (y.right != null) {
            y.right.parent = y;
        }
        x.right = y;
    }

    /* Rotera 1 steg i vanstervarv:
            x'                 y'
           / \                / \
          A   y'  -->        x'  C
             / \            / \
            B   C          A   B
    */
    private void zag(Entry x) {
        Entry y = x.right;
        E temp = x.element;
        x.element = y.element;
        y.element = temp;
        x.right = y.right;

        if (x.right != null) {
            x.right.parent = x;
        }
        y.right = y.left;
        y.left = x.left;

        if (y.left != null) {
            y.left.parent = y;
        }
        x.left = y;
    }

    /* Rotera vanster sedan hoger:
            x'                  z'
           / \                /   \
          y'  D   -->        y'    x'
         / \                / \   / \
        A   z'             A   B C   D
           / \
          B   C
    */
    private void zagZig(Entry x) {
        Entry y = x.left;
        Entry z = x.left.right;
        E temp = x.element;
        x.element = z.element;
        z.element = temp;
        y.right = z.left;
        if (y.right != null) {
            y.right.parent = y;
        }
        z.left = z.right;
        z.right = x.right;
        if (z.right != null) {
            z.right.parent = z;
        }
        x.right = z;
        z.parent = x;
    }

    /* Rotera höger sedan vanster:
            x'                  z'
           / \                /   \
          A   y'   -->       x'    y'
             / \            / \   / \
            z   D          A   B C   D
           / \
          B   C
     */
    private void zigZag(Entry x) {
        Entry y = x.right;
        Entry z = x.right.left;
        E temp = x.element;
        x.element = z.element;
        z.element = temp;
        y.left = z.right;

        if (y.left != null) {
            y.left.parent = y;
        }
        z.right = z.left;
        z.left = x.left;

        if (z.left != null) {
            z.left.parent = z;
        }
        x.left = z;
        z.parent = x;
    }

    /* Rotera 2 steg i vanstervarv:
           x'                  z
          / \                 / \
         G   y'   -->        y'  C
            / \             / \
           A   z           x'  B
              / \         / \
             B   C       G   A
    */
    private void zigZig(Entry x) {
        Entry y = x.right;
        Entry z = x.right.right;
        E temp = x.element;

        //Byt plats på x och z element
        x.element = z.element;
        z.element = temp;

        x.right = z.right;//z.right = C
        if (x.right != null) {
            x.right.parent = x;//C.parent = z
        }

        y.right = z.left;//y.right = B
        if (y.right != null) {
            y.right.parent = y;//B.parent = y
        }

        z.right = y.left;//x.right = A
        if (y.left != null) {
            y.left.parent = z;//A.parent = x
        }

        z.left = x.left;//x.left = G
        if (z.left != null) {
            z.left.parent = z;
        }

        x.left = y;
        y.left = z;
    }

    /* Rotera 2 steg i hogervarv:
            x'                  z'
           / \                 / \
          y'  D      -->      A   y'
         / \                     / \
        z'  C                   B   x'
       / \                         / \
      A   B                       C   D
    */
    private void zagZag(Entry x) {
        Entry y, z;
        y = x.left;
        z = x.left.left;

        E e = x.element;
        x.element = z.element;
        z.element = e; // byter plats på x och y's element

        x.left = z.left; // hänger på A på toppen
        if (x.left != null) {
            x.left.parent = x;
        }

        y.left = z.right; // hänger på B på y'
        if (y.left != null) {
            y.left.parent = y;
        }

        z.left = y.right; // hänger på C på x'
        if (z.left != null) {
            z.left.parent = z;
        }

        z.right = x.right; // hänger på D på x'
        if (z.right != null) {
            z.right.parent = z;
        }

        x.right = y;
        y.right = z;
    }

    @Override
    public E get(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (e.compareTo(root.element) == 0) {
            return root.element;
        }

        Entry entry = find(e, root);

        if (entry == null) {
            return null;
        }

        Entry parent;
        Entry grandParent;

        while (entry.element.compareTo(root.element) != 0) {
            parent = entry.parent;
            grandParent = parent.parent;

            if (grandParent == null) {
                if (equals(parent.left, entry)) {
                    zig(parent);
                } else {
                    zag(parent);
                }
                return root.element;
            }

            //grandParent != null
            if (equals(grandParent.left, parent)) {
                if (equals(parent.left, entry)) {
                    zagZag(grandParent);
                } else {
                    zagZig(grandParent);
                }
            } else {
                if (equals(parent.right, entry)) {
                    zigZig(grandParent);
                } else {
                    zigZag(grandParent);
                }
            }


            entry = grandParent;
        }

        return root.element;
    }

    private boolean equals(Entry e1, Entry e2) {
        if (e1 == null || e2 == null) {
            return false;
        }
        return e1.element.compareTo(e2.element) == 0;
    }
}
