class Link<E> {
    E value;
    Link next = null;

    public E getValue() { return value; }
    public Link getNext() { return next; }
    public void setNext(Link next) {
        this.next = next;
    }

    public Link(E value) {
        this.value = value;
    }
}

class MyLinkedList<E> {
    private Link<E> start;
    private Link<E> end;

    public Link<E> getStart() {
        return start;
    }

    public Link<E> getEnd() {
        return end;
    }

    public void addFirst(E value) {
        Link<E> newLink = new Link<>(value);
        newLink.setNext(start);
        start = newLink;

        if(end == null)
            end = newLink;
    }

    public void addLast(E value) {
        Link<E> newLink = new Link<>(value);

        if(end == null) {
            start = newLink;
            end = newLink;
        }
        else {
            end.setNext(newLink);
            end = newLink;
        }
    }
}

class MyIterator<E> {
    MyLinkedList<E> list;
    Link current = null;

    public Object getValue() { return current.getValue(); }

    public MyIterator(MyLinkedList<E> list) {
        this.list = list;
    }

    public void next() {
        if(current == null)
            current = list.getStart();
        else
            current = current.getNext();
    }

    public boolean hasNext() {
        return current == null || current.getNext() != null;
    }
}

void main() {
    MyLinkedList<String> list = new MyLinkedList<>();

    list.addLast("Hello");
    list.addLast("World");
    list.addLast("Bye");
    list.addFirst("!");

    MyIterator<String> iterator = new MyIterator<>(list);

    while(iterator.hasNext()) {
        iterator.next();
        System.out.println(iterator.getValue());
    }
}