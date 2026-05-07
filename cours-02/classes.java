// Classes en java.

public class Main
{
    public static class Point {
        private int x;
        private int y;
        
        public void initialize(int x, int y) {
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
	    p.initialize(2, 4);
	    p.print();
	    p.move(2, 2);
	    p.print();
	}
}