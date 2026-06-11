class MyBinaryTree {
    private Node root;

    public void insert(int value){
        insertNode(new Node(value));
    }

    private void insertNode(Node newNode) {
        if(newNode == null)
            return;

        int value = newNode.getValue();
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

    public void remove(int value) {
        if(root == null)
            return;

        Node parent = null;
        Node current = root;

        while (current != null && current.getValue() != value) {
            parent = current;

            if (current.getValue() > value) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        if(current == null)
            return;

        Node successor = current.getSuccessor();
        if(successor != null) {
            if(successor == current.getRight()) {
                insertNode(current.getLeft());
            }
        }

        if(parent.getLeft() == current)
            parent.setLeft(successor);
        else
            parent.setRight(successor);
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
    private int value;
    private Node left;
    private Node right;

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

    public Node getSuccessor() {
        return right != null ? right : left;
    }
}

void main() {
    MyBinaryTree tree = new MyBinaryTree();
    tree.insert(63);
    tree.insert(27);
    tree.insert(80);
    tree.insert(13);
    tree.insert(51);
    tree.insert(26);
    tree.insert(33);
    tree.insert(32);
    tree.insert(70);
    tree.insert(92);
    tree.insert(58);
    tree.insert(57);
    tree.insert(60);

    tree.remove(92);

    tree.printSorted();

    System.out.println(tree.min());
    System.out.println(tree.max());
    System.out.println(tree.exists(8));
    System.out.println(tree.exists(12));
}