package Board;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void substitute(Point p){
        int tempX = x;
        int tempY = y;
        x = p.x;
        y = p.y;
        p.x = tempX;
        p.y = tempY;
    }

    public double range(Point p){
        return Math.sqrt((this.x-p.x)*(this.x-p.x) + (this.y-p.y)*(this.y-p.y));
    }
}
