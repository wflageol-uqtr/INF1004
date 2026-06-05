class Link {
    int value;
    Link next = null;

    public int getValue() { return value; }
    public Link getNext() { return next; }
    public void setNext(Link next) {
        this.next = next;
    }

    public Link(int value) {
        this.value = value;
    }
}

class MyLinkedList {
    private Link start;
    private Link end;

    public Link getStart() {
        return start;
    }

    public Link getEnd() {
        return end;
    }

    public void addFirst(int value) {
        Link newLink = new Link(value);
        newLink.setNext(start);
        start = newLink;

        if(end == null)
            end = newLink;
    }

    public void addLast(int value) {
        Link newLink = new Link(value);

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

class MyIterator {
    MyLinkedList list;
    Link current = null;

    public int getValue() { return current.getValue(); }

    public MyIterator(MyLinkedList list) {
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
    MyLinkedList list = new MyLinkedList();

    list.addLast(1);
    list.addLast(3);
    list.addLast(5);
    list.addFirst(0);

    MyIterator iterator = new MyIterator(list);

    while(iterator.hasNext()) {
        iterator.next();
        System.out.println(iterator.getValue());
    }
}