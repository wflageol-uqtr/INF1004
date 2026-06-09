class MyBinaryTree {
    Node root;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null)
            root = newNode;
        else {
            Node parent = null;
            Node current = root;

            while (current != null) {
                parent = current;
                if (current.getValue() > value) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }

            if (parent.getValue() > value)
                parent.setLeft(newNode);
            else
                parent.setRight(newNode);
        }
    }

    private int search(boolean goLeft) {
        Node previous = null;
        Node current = root;

        while(current != null) {
            previous = current;
            current = goLeft ? current.getLeft() : current.getRight();
        }

        return previous.getValue();
    }

    public int min() { return search(true); }

    public int max() { return search(false); }

    public boolean exists(int value) {
        Node current = root;

        while(current != null) {
            if(current.getValue() == value)
                return true;

            if(current.getValue() > value)
                current = current.getLeft();
            else
                current = current.getRight();
        }

        return false;
    }

    public void printSorted() {
        printSorted(root);
    }

    public void printSorted(Node node) {
        if(node == null)
            return;

        printSorted(node.getLeft());
        System.out.println(node.getValue());
        printSorted(node.getRight());
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}

void main() {
    MyBinaryTree tree = new MyBinaryTree();
    tree.insert(1);
    tree.insert(7);
    tree.insert(3);
    tree.insert(8);
    tree.insert(2);

    tree.printSorted();

    System.out.println(tree.min());
    System.out.println(tree.max());
    System.out.println(tree.exists(8));
    System.out.println(tree.exists(12));
}