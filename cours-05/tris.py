def bubblesort(array):
    changed = True
    while changed:
        changed = False
        for i in range(len(array) - 1):
            if array[i] > array[i+1]:
                array[i], array[i+1] = array[i+1], array[i]
                changed = True
                
def selectionSort(array):
    for i, e in enumerate(array):
        minimum = min(range(i, len(array)), key=array.__getitem__)
        array[i], array[minimum] = array[minimum], e
        
def insertionSort(array):
    for i, v in enumerate(array):
        for j in range(i - 1, -1, -1):
            if array[j] > v:
                array[j+1] = array[j]
                array[j] = v
                
def shellSort(array):
    step = 1
    while step <= len(array) // 3:
        step = step * 3 + 1
    while step:
        for i, e in enumerate(array[step:], step):
            while i >= step and array[i - step] > e:
                array[i] = array[i - step]
                i -= step
            array[i] = e
        step = (step - 1) // 3

array = [15, 5, 11, 1, 23, 19]

shellSort(array)

print(array)