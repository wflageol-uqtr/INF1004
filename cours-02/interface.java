// Interface Java.

import java.util.ArrayList;

public class Main
{
    public interface Coord {
        int getX();
        int getY();
        
        void print();
    }
    
    public static class Point implements Coord {
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
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
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
        
        public void move(int dx, int dy) {
            x += dx;
            y += dy;
        }
        
        public void move(int delta) {
            move(delta, delta);
        }
        
        public void print() {
            System.out.println("(" + x + ", " + y + ")");
        }
    }
    
    public static class Rectangle extends Point {
        private int width;
        private int height;
        
        public Rectangle(int x, int y, int width, int height) {
            super(x, y);
            
            this.width = width;
            this.height = height;
        }
        
        @Override
        public void print() {
            System.out.println("(" + getX() + ", " + getY() + ", " + width + ", " + height + ")");
        }
    }
    
	public static void main(String[] args) {
	    ArrayList<Coord> points = new ArrayList<Coord>();
	    
	    Point p = new Point(3, 4);
	    Rectangle r = new Rectangle(1, 2, 3, 4);
	    
	    points.add(p);
	    points.add(r);
	    
	    r.move(2, 2);
	    
	    for(Coord c : points) {
	        c.print();
	    }
	}
}