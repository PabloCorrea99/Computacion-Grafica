
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

    public int getX2() {
        return point2.getX();
    }
    
    public int getY2() {
        return point2.getY();
    }

    public void setX1(int x) {
        point1.setX(x);
    }

    public void setY1(int y) {
        point1.setY(y);
    }

    public void setX2(int x) {
        point2.setX(x);
    }

    public void setY2(int y) {
        point2.setY(y);
    }

}