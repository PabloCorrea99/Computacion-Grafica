
public class Point {
    
    int point[] = new int[3];
    
    public Point(int x, int y, int z){
        point[0] = x;
        point[1] = y;
        point[2] = z;
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

    public int getZ() {
        return point[2];
    }

    public void setX(int x) {
        point[0] = x;
    }

    public void setY(int y) {
        point[1] = y;
    }

    public void setz(int z) {
        point[2] = z;
    }
}