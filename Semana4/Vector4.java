import java.lang.Math;

public class Vector4 {
    private double x;
    private double y;
    private double w;
    private double z;

    public Vector4(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getW() {
        return w;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setW(double w) {
        this.w = w;
    }

    public static Vector4 crossProduct(Vector4 v1, Vector4 v2) {
        Vector4 result = new Vector4();

        return result;
    }

    public static double dotProduct(Vector4 v1, Vector4 v2) {
        return (v1.getX() * v2.getX()) + (v1.getY() * v2.getY()) + (v1.getZ() * v2.getZ()) + (v1.getW() * v2.getW());
    }

    public double Magnitude() {
        return Math.sqrt((Math.pow(this.getX(), 2)) + (Math.pow(this.getY(), 2)) + (Math.pow(this.getZ(), 2))
                + (Math.pow(this.getW(), 2)));
    }

    public void Normalize(){
        double magnitude = Magnitude();
        this.setX((this.getX()/magnitude));
        this.setY((this.getY()/magnitude));
        this.setZ((this.getZ()/magnitude));
        this.setW((this.getW()/magnitude));

        System.out.println(this.getX() + " " + this.getY() + " " + this.getZ() + " " + this.getW());
    }
}
