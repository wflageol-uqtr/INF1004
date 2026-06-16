class MyHeap {
    ArrayList<PriorityNode> nodes = new ArrayList<>();

    private void trickleUp(int index) {
        if(index == 0)
            return;

        int parentIndex = (index + 1) / 2 - 1;
        PriorityNode current = nodes.get(index);
        PriorityNode parent = nodes.get(parentIndex);

        if(current.priority > parent.priority) {
            Collections.swap(nodes, index, parentIndex);
            trickleUp(parentIndex);
        }
    }

    private void trickleDown(int index) {
        if(index >= nodes.size())
            return;

        int leftIndex = (index + 1) * 2 - 1;
        int rightIndex = leftIndex + 1;

        PriorityNode leftNode = leftIndex < nodes.size() ? nodes.get(leftIndex) : null;
        PriorityNode rightNode = rightIndex < nodes.size() ? nodes.get(rightIndex) : null;

        if(leftNode == null && rightNode == null) {
            nodes.set(index, null);
        } else if (leftNode == null) {
            Collections.swap(nodes, index, rightIndex);
            trickleDown(rightIndex);
        } else if (rightNode == null) {
            Collections.swap(nodes, index, leftIndex);
            trickleDown(leftIndex);
        } else if (leftNode.priority < rightNode.priority) {
            Collections.swap(nodes, index, rightIndex);
            trickleDown(rightIndex);
        } else {
            Collections.swap(nodes, index, leftIndex);
            trickleDown(leftIndex);
        }
    }

    public void enqueue(int priority, String value) {
        nodes.addLast(new PriorityNode(priority, value));
        trickleUp(nodes.size() - 1);
    }

    public String dequeue() {
        PriorityNode node = nodes.getFirst();
        trickleDown(0);
        return node.value;
    }

    public boolean isEmpty() {
        return nodes.isEmpty() || nodes.getFirst() == null;
    }
}

class PriorityNode {
    private final int priority;
    private final String value;
    PriorityNode left;
    PriorityNode right;

    public PriorityNode(int priority, String value) {
        this.priority = priority;
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public String getValue() {
        return value;
    }

    public PriorityNode getLeft() {
        return left;
    }

    public PriorityNode getRight() {
        return right;
    }

    public void setLeft(PriorityNode left) {
        this.left = left;
    }

    public void setRight(PriorityNode right) {
        this.right = right;
    }
}


void main() {
    MyHeap heap = new MyHeap();

    heap.enqueue(5, "phrase ");
    heap.enqueue(3, "est ");
    heap.enqueue(1, "en ");
    heap.enqueue(7, "Cette ");
    heap.enqueue(0, "ordre.");

    while(!heap.isEmpty())
        System.out.println(heap.dequeue());
}