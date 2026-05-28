def merge (array1, array2):
    i = 0
    j = 0
    result = []
    while i < len(array1) and j < len(array2):
        if array1[i] > array2[j]:
            result.append(array2[j])
            j += 1
        else:
            result.append(array1[i])
            i += 1
            
    if i < len(array1):
        result += array1[i:]
    if j < len(array2):
        result += array2[j:]
        
    return result
    
def mergeSort(array):
    if len(array) <= 1: return array
    
    center = len(array) // 2
    lowerHalf = mergeSort(array[0:center])
    upperHalf = mergeSort(array[center:])
    return merge(lowerHalf, upperHalf)
    
a = [5, 1, 4, 7, 2, 8]

print(mergeSort(a))