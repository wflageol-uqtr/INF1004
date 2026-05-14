class MyArray {
    private int[] innerArray = new int[100];
    private int size = 0;

    public int get(int index) {
        return innerArray[index];
    }

    // Big(O): n
    public void insert(int n) {
        if(size == 0) {
            innerArray[0] = n;
        } else {
            for(int i = size - 1; i >= 0; i--) {
                if(innerArray[i] > n) {
                    innerArray[i + 1] = innerArray[i];
                } else {
                    innerArray[i + 1] = n;
                    break;
                }
            }
        }

        size++;
    }

    // Big(O): n
    public int search(int n) {
        for(int i = 0; i < size; i++) {
            if(innerArray[i] == n)
                return i;
        }

        return -1;
    }

    // Big(O): log(n)
    public int searchBinary(int n) {
        int lower = 0;
        int higher = size - 1;
        int middle;

        do {
            middle = (int)Math.ceil(lower + (higher - lower) / 2.0);
            if(innerArray[middle] > n) {
                higher = middle;
            }
            if(innerArray[middle] < n) {
                lower = middle;
            }
        } while(n != innerArray[middle]
                && lower != higher);

        if(innerArray[middle] == n)
            return middle;
        else
            return -1;
    }
}

void main() {
    MyArray intArray = new MyArray();
    intArray.insert(15);
    intArray.insert(42);
    intArray.insert(20);
    intArray.insert(30);
    intArray.insert(70);
    intArray.insert(58);
    intArray.insert(40);
    intArray.insert(55);

    System.out.println(intArray.searchBinary(58));
}