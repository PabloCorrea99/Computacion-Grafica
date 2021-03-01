
public class Point {
    
    int point[] = new int[2];
    
    public Point(int x, int y){
        point[0] = x;
        point[1] = y;
    }

    public int[] getPoint() {
        return point;
    }

    public int getX() {
        return point[0];
    }
    
    public int getY() {
        return point[1];
    }

    public void setX(int x) {
        point[0] = x;
    }

    public void setY(int y) {
        point[1] = y;
    }
}