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

    public void insert(int value) {
        Link newLink = new Link(value);

        Link previous = null;
        Link current = start;

        if(current == null) {
            start = newLink;
            return;
        }

        while(current.getValue() <= value) {
            previous = current;
            current = current.getNext();
        }

        if(current == start) {
            newLink.setNext(start);
            start = newLink;
        } else {
            if(current == end) {
                end = newLink;
            }

            newLink.setNext(current);
            previous.setNext(newLink);
        }
    }

    public void removeFirst() {
        start = start.getNext();
    }

    public void remove(int index) {
        if(index == 0) {
            start = start.getNext();
        } else {
            Link previous = null;
            Link next = null;
            Link current = start;
            for(int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
                next = current.getNext();
            }
            previous.setNext(next);
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

    list.insert(5);
    list.insert(1);
    list.insert(0);
    list.insert(3);

    MyIterator iterator = new MyIterator(list);

    while(iterator.hasNext()) {
        iterator.next();
        System.out.println(iterator.getValue());
    }
}