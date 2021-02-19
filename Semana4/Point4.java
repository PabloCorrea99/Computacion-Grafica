/**
 *
 * @author jricaur1 y pcorream2
 */
class Point4 {

    private double x,y,z,w;

    public Point4(double x, double y, double z, double w){
        this.x=x;
        this.y=y;
        this.z=z;
        this.w=w;
    }

    public Point4(){
        this.x=0;
        this.y=0;
        this.z=0;
        this.w=0;
    }

    public double getX(){
        return x;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return y;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getZ(){
        return z;
    }

    public void setZ(double z){
        this.z = z;
    }

    public double getW(){
        return w;
    }

    public void setW(double w){
        this.w = w;
    }

}