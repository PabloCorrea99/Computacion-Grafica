
public class Edge {
    Point point1;
    Point point2;

    public Edge(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public int getX1() {
        return point1.getX();
    }
    
    public int getY1() {
        return point1.getY();
    }

    public int getZ1() {
        return point1.getZ();
    }

    public int getX2() {
        return point2.getX();
    }
    
    public int getY2() {
        return point2.getY();
    }

    public int getZ2() {
        return point2.getZ();
    }

    public void setX1(int x) {
        point1.setX(x);
    }

    public void setY1(int y) {
        point1.setY(y);
    }

    public void setZ1(int z) {
        point1.setZ(z);
    }

    public void setX2(int x) {
        point2.setX(x);
    }

    public void setY2(int y) {
        point2.setY(y);
    }

    public void setZ2(int z) {
        point2.setZ(z);
    }

}