class MyStack {
    private ArrayList<Integer> innerList = new ArrayList<>();

    // O(1)
    public void push(int n) {
        innerList.addFirst(n);
    }

    // O(1)
    public int peek() {
        return innerList.getFirst();
    }

    // O(1)
    public int pop() {
        int returnValue = peek();
        innerList.removeFirst();

        return returnValue;
    }

    // O(1)
    public void replace(int n) {
        pop();
        push(n);
    }

    // O(1)
    public boolean isEmpty() {
        return innerList.isEmpty();
    }

    // O(1)
    public int size() {
        return innerList.size();
    }
}

class MyQueue {
    private ArrayList<Integer> innerList = new ArrayList<>();

    public void enqueue(int n) {
        innerList.addLast(n);
    }

    public int dequeue() {
        return innerList.removeFirst();
    }

    public int peek() {
        return innerList.getFirst();
    }

    public boolean isEmpty() {
        return innerList.isEmpty();
    }

    public int size() {
        return innerList.size();
    }
}

class MyPriorityQueue<T> {
    private class PriorityTuple {
        public T value;
        public int priority;

        public PriorityTuple(T value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    ArrayList<PriorityTuple> innerList = new ArrayList<>();

    // O(n)
    public void enqueue(T value, int priority) {
        innerList.add(new PriorityTuple(value, priority));
        innerList.sort(Comparator.comparingInt((PriorityTuple t) -> t.priority));
    }

    // O(1)
    public T dequeue() {
        return innerList.removeFirst().value;
    }

    // O(1)
    public boolean isEmpty() {
        return innerList.isEmpty();
    }
}

void main() {
    MyStack pile = new MyStack();

    pile.push(15);
    pile.push(20);
    pile.push(30);
    pile.push(40);

    while(!pile.isEmpty())
        System.out.println(pile.pop());

    MyQueue file = new MyQueue();

    file.enqueue(15);
    file.enqueue(20);
    file.enqueue(30);
    file.enqueue(40);

    while(!file.isEmpty())
        System.out.println(file.dequeue());

    MyPriorityQueue<String> filePrio = new MyPriorityQueue<>();

    filePrio.enqueue("Important", 1);
    filePrio.enqueue("Pas important", 4);
    filePrio.enqueue("Très important", 0);

    while(!filePrio.isEmpty())
        System.out.println(filePrio.dequeue());
}