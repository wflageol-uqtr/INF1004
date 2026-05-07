// Égalités en Java

public class Main
{
    public static class Point {
        private int x;
        private int y;
        
        public Point() { 
            x = 0;
            y = 0;
        }
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Point) {
               Point p = (Point)obj;
               return x == p.x && y == p.y;
            } else {
                return false;
            }
        }
        
        @Override
        public int hashCode() {
            // ...
        }
        
        public void move(int dx, int dy) {
            x += dx;
            y += dy;
        }
        
        public void print() {
            System.out.println("(" + x + ", " + y + ")");
        }
    }
    
	public static void main(String[] args) {
	    Point p = new Point(3, 4);
	    Point p2 = new Point(3, 4);
	    
	    p.print();
	    p2.print();
	    
	    System.out.println(p.equals(p2));
	}
}