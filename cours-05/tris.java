void bubblesort(int[] array) {
    boolean changed = true;

    while(changed) {
        changed = false;

        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i+1]) {
                int temp = array[i+1];
                array[i+1] = array[i];
                array[i] = temp;
                changed = true;
            }
        }
    }
}

void selectionSort(int[] array) {
    for(int i = 0 ; i < array.length - 1; i++) {
        int smallest = Integer.MAX_VALUE;
        int smallestIndex = -1;

        for(int j = i; j < array.length; j++) {
            if(array[j] < smallest) {
                smallest = array[j];
                smallestIndex = j;
            }
        }

        int temp = array[i];
        array[i] = array[smallestIndex];
        array[smallestIndex] = temp;
    }
}

void insertionSort(int[] array) {
    for(int i = 0; i < array.length; i++) {
        int v = array[i];
        int j = i - 1;
        while(j >= 0 && array[j] > v) {
            array[j + 1] = array[j];
            j -= 1;
        }
        array[j + 1] = v;
    }
}

void shellSort(int[] array) {
    int step = array.length / 2;
    while(step > 0) {
        for(int i = step; i < array.length; i++) {
            int j = i;
            int v = array[i];
            while(j >= step && array[j - step] > v) {
                array[j] = array[j - step];
                j = j - step;
            }
            array[j] = v;
        }

        if(step == 2)
            step = 1;
        else
            step *= (5.0 / 11);
    }
}

List<Integer> quicksort(List<Integer> array) {
    if(array.size() < 2)
        return array;

    int pivot = array.getFirst();

    List<Integer> lesser = new LinkedList<>();
    List<Integer> equal = new LinkedList<>();
    List<Integer> greater = new LinkedList<>();

    for(int e : array) {
        if (e < pivot) lesser.add(e);
        else if (e > pivot) greater.add(e);
        else equal.add(e);
    }

    lesser = quicksort(lesser);
    greater = quicksort(greater);

    lesser.addAll(equal);
    lesser.addAll(greater);

    return lesser;
}

void main() {
    Integer[] array = { 16, 5, 11, 1, 23, 19 };

    List<Integer> result = quicksort(Arrays.asList(array));

    for(int i : result)
        System.out.println(i);
}