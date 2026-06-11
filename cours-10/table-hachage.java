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
    private KeyValuePair[] innerArray = new KeyValuePair[100];

    private int getHashCode(int key) {
        return key % innerArray.length;
    }

    private int handleCollision(int index) {
        int currentIndex = index + 1;
        while(currentIndex != index) {
            if(innerArray[index] == null)
                return index;

            index = index + 1 % innerArray.length;
        }

        throw new IllegalArgumentException();
    }

    public void put(int key, String value) {
        int index = getHashCode(key);
        KeyValuePair current = innerArray[index];

        if(current != null && current.key != key) {
            index = handleCollision(index);
        }

        innerArray[index] = new KeyValuePair(key, value);
    }

    public void print() {
        for(int i = 0; i < innerArray.length; i++) {
            KeyValuePair kvp = innerArray[i];
            if(kvp != null)
                System.out.printf("%d: %s%n", i, kvp.value);
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
    hash.put(1, "Hello");
    hash.put(150, "World!");

    hash.print();
}