/**
 *
 * @author jricaur1 y pcorream2
 */
class Point3 {

    private double x;
    private double y;
    private double w;

    public Point3(double x, double y, double w){
        this.x = x;
        this.y = y;
        this.w = w;
    }
    public Point3(){
        this.x = 0;
        this.y = 0;
        this.w = 0;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getW(){
        return w;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setW(double w){
        this.w = w;
    }
}
