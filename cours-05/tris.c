
#include <stdio.h>

void bubblesort(int* array, int n) {
    int changed = 1;

    while(changed) {
        changed = 0;

        for(int i = 0; i < n - 1; i++) {
            if(array[i] > array[i+1]) {
                int temp = array[i+1];
                array[i+1] = array[i];
                array[i] = temp;
                changed = 1;
            }
        }
    }
}

void selectionSort(int* array, int n) {
    for(int i = 0 ; i < n - 1; i++) {
        int smallest;
        int smallestIndex = -1;

        for(int j = i; j < n; j++) {
            if(array[j] < smallest || smallestIndex < 0) {
                smallest = array[j];
                smallestIndex = j;
            }
        }

        int temp = array[i];
        array[i] = array[smallestIndex];
        array[smallestIndex] = temp;
    }
}

void insertionSort(int* array, int n) {
    for(int i = 0; i < n; i++) {
        int v = array[i];
        int j = i - 1;
        while(j >= 0 && array[j] > v) {
            array[j + 1] = array[j];
            j -= 1;
        }
        array[j + 1] = v;
    }
}

void shellSort(int* array, int n) {
    int step = n / 2;
    while(step > 0) {
        for(int i = step; i < n; i++) {
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
            step *= 5.0 / 11;
    }
}

int main()
{
    int n = 6;
    int array[6] = { 16, 5, 11, 1, 23, 19 };

    shellSort(array, n);

    for(int i = 0; i < n; i++)
        printf("%i\n", array[i]);

    return 0;
}