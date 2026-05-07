# Classes en Python.

class Point:
    def initialize(self, x, y):
        self.x = x
        self.y = y
        
    def move(self, dx, dy):
        self.x += dx
        self.y += dy
        
    def print(self):
        print(f"({self.x}, {self.y})")
        
p = Point()
p.initialize(2, 4)
p.print()
p.move(2, 2)
p.print()