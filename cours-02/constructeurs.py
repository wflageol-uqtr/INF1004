// Constructeurs d'objet en Python.

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        
    def move(self, dx, dy):
        self.x += dx
        self.y += dy
        
    def print(self):
        print(f"({self.x}, {self.y})")
        
p = Point(2, 4)
p.print()
p.move(2, 2)
p.print()