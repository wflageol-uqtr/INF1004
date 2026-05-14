import math

class MyArray:
    innerArray = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    size = 0
    
    def insert(self, n):
        if(self.size == 0):
            self.innerArray[0] = n
        else:
            for i in reversed(range(0, self.size)):
                if(self.innerArray[i] > n):
                    self.innerArray[i + 1] = self.innerArray[i]
                else:
                    self.innerArray[i + 1] = n
                    break
        
        self.size += 1
        
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
        

intArray = MyArray()
intArray.insert(15)
intArray.insert(42)
intArray.insert(20)
intArray.insert(30)
intArray.insert(70)
intArray.insert(58)
intArray.insert(40)
intArray.insert(55)

print(intArray.search(70))
