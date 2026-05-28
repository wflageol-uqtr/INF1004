def binarySearch(array, n):
    pivotIndex = len(array) // 2
    pivot = array[pivotIndex]
    
    if pivot == n: return pivot
    
    if n > pivot:
        return binarySearch(array[pivotIndex:], n)
    else: 
        return binarySearch(array[0:pivotIndex], n)
    
def search(self, n):
    lower = 0
    higher = self.size - 1
    
    while lower <= higher:
        middle = math.ceil(lower + (higher - lower) / 2)
        
        if n == self.innerArray[middle]:
            return middle;
        if self.innerArray[middle] > n:
            higher = middle - 1
        if self.innerArray[middle] < n:
            lower = middle + 1
    
    return -1
    
array = [1, 4, 7, 12, 15]

print(binarySearch(array, 20))