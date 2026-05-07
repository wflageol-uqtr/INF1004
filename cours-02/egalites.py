# Égalités en Python.

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        
    def __eq__(self, obj):
        if isinstance(obj, Point):
            return self.x == obj.x and self.y == obj.y
        return False
        
    def move(self, dx, dy):
        self.x += dx
        self.y += dy
        
    def print(self):
        print(f"({self.x}, {self.y})")
        
p = Point(2, 4)
p2 = Point(2, 4)

print(p == p2)