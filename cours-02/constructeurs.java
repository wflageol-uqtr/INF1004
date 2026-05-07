// Constructeurs d'objet en Java.

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
        
        public void move(int dx, int dy) {
            x += dx;
            y += dy;
        }
        
        public void print() {
            System.out.println("(" + x + ", " + y + ")");
        }
    }
    
	public static void main(String[] args) {
	    Point p = new Point();
	    p.print();
	    p.move(2, 2);
	    p.print();
	}
}