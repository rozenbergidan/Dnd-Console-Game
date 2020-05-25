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
        setX(p.x);
        setY(p.y);
        p.setX(tempX) ;
        p.setY(tempY);
    }

    public double range(Point p){
        return Math.sqrt((this.x-p.x)*(this.x-p.x) + (this.y-p.y)*(this.y-p.y));
    }

    public void setX(int i) {
        x=i;
    }
    public void setY(int j){
        y=j;
    }
}
