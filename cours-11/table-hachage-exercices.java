class Coord {
    private int x;
    private int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Coord c) {
            return c.x == x && c.y == y;
        } else return false;
    }

    @Override
    public int hashCode() {
        int temp = y + ((x + 1) / 2);
        return x + (temp * temp);
    }
}

class MyHashTable {
    private LinkedList<KeyValuePair>[] innerArray = new LinkedList[100];

    private int getHashCode(int key) {
        return key % innerArray.length;
    }

    private int handleCollision(int index) {
        int currentIndex = index + 1;
        while(currentIndex != index) {
            if(innerArray[currentIndex] == null)
                return currentIndex;

            currentIndex = currentIndex + 1 % innerArray.length;
        }

        throw new IllegalArgumentException();
    }

    public void put(int key, String value) {
        int index = getHashCode(key);
        LinkedList<KeyValuePair> current = innerArray[index];

        if(current == null) {
            current = new LinkedList<>();
            innerArray[index] = current;
        }

        current.addFirst(new KeyValuePair(key, value));
    }

    public void remove(int key) {
        int index = getHashCode(key);
        LinkedList<KeyValuePair> current = innerArray[index];

        if(current == null)
            return;

        // current.removeIf((kvp) -> kvp.key == key);
        for(KeyValuePair kvp : current) {
            if(kvp.key == key) {
                current.remove(kvp);
                break;
            }
        }
    }

    public void print() {
        for(int i = 0; i < innerArray.length; i++) {
            LinkedList<KeyValuePair> kvpList = innerArray[i];
            if(kvpList != null) {
                for(KeyValuePair kvp : kvpList)
                    System.out.printf("%d: %s%n", i, kvp.value);
            }
        }
    }
}

class KeyValuePair {
    private final int key;
    private final String value;

    KeyValuePair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

void main() {
    MyHashTable hash = new MyHashTable();

    for(Integer i = 1; i <= 1000; i++) {
        hash.put(i, i.toString());
    }

    hash.print();
}