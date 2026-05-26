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
        
def quickSort(array):
    if len(array) <= 1:
        return array

    lesser = []
    equal = []
    greater = []
    
    pivot = array[0]
    for e in array:
        if e < pivot:
            lesser.append(e)
        elif e > pivot:
            greater.append(e)
        else:
            equal.append(e)

    return quickSort(lesser) + equal + quickSort(greater)
    
def quickSortF(array):
    if not array:
        return []
    else:
        pivot = array[0]
        lesser = [x for x in array[1:] if x < pivot]
        greater = [x for x in array[1:] if x >= pivot]
        return quickSortF(lesser) + [pivot] + quickSortF(greater)


array = [15, 5, 11, 1, 23, 19]

array = quickSortF(array)

print(array)