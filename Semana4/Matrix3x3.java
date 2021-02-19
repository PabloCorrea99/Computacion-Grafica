import Point3;

public class Matrix3x3 {
    private double m11;
    private double m12;
    private double m13;
    private double m21;
    private double m22;
    private double m23;
    private double m31;
    private double m32;
    private double m33;

    public Matrix3x3(double m11, double m12, double m13, double m21, double m22, double m23, double m31, double m32, double m33){
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
    }

    public Matrix3x3(){
        this.m11 = 0;
        this.m12 = 0;
        this.m13 = 0;
        this.m21 = 0;
        this.m22 = 0;
        this.m23 = 0;
        this.m31 = 0;
        this.m32 = 0;
        this.m33 = 0;
    }

    public double getM11(){
        return m11;
    }

    public double getM12(){
        return m12;
    }

    public double getM13(){
        return m13;
    }

    public double getM21(){
        return m21;
    }

    public double getM22(){
        return m22;
    }

    public double getM23(){
        return m23;
    }

    public double getM31(){
        return m31;
    }

    public double getM32(){
        return m32;
    }

    public double getM33(){
        return m33;
    }

    public void setM11(double m11){
        this.m11 = m11;
    }

    public void setM12(double m12){
        this.m12 = m12;
    }
    public void setM13(double m13){
        this.m13 = m13;
    }
    public void setM21(double m21){
        this.m21 = m21;
    }
    public void setM22(double m22){
        this.m22 = m22;
    }
    public void setM23(double m23){
        this.m23 = m23;
    }
    public void setM31(double m31){
        this.m31 = m31;
    }
    public void setM32(double m32){
        this.m32 = m32;
    }
    public void setM33(double m33){
        this.m33 = m33;
    }

    public static Point3 times(Matrix3x3 matrix, Point3 point){
        Point3 result = new Point3();
        result.setX((matrix.getM11() * point.getX()) + (matrix.getM12() * point.getY()) + (matrix.getM13() * point.getW()));
        result.setY((matrix.getM21() * point.getX()) + (matrix.getM22() * point.getY()) + (matrix.getM23() * point.getW()));
        result.setW((matrix.getM31() * point.getX()) + (matrix.getM32() * point.getY()) + (matrix.getM33() * point.getW()));
        return result;
    }

    public static Matrix3x3 times(Matrix3x3 matrix1, Matrix3x3 matrix2){
        Matrix3x3 result = new Matrix3x3();
        //Fila 1
        result.setM11((matrix1.getM11() * matrix2.getM11()) + (matrix1.getM12() * matrix2.getM21()) + (matrix1.getM13() * matrix2.getM31()));
        result.setM12((matrix1.getM11() * matrix2.getM12()) + (matrix1.getM12() * matrix2.getM22()) + (matrix1.getM13() * matrix2.getM32()));
        result.setM13((matrix1.getM11() * matrix2.getM13()) + (matrix1.getM12() * matrix2.getM23()) + (matrix1.getM13() * matrix2.getM33()));
        //Fila 2
        result.setM21((matrix1.getM21() * matrix2.getM11()) + (matrix1.getM22() * matrix2.getM21()) + (matrix1.getM23() * matrix2.getM31()));
        result.setM22((matrix1.getM21() * matrix2.getM12()) + (matrix1.getM22() * matrix2.getM22()) + (matrix1.getM23() * matrix2.getM32()));
        result.setM23((matrix1.getM21() * matrix2.getM13()) + (matrix1.getM22() * matrix2.getM23()) + (matrix1.getM23() * matrix2.getM33()));
        //Fila3
        result.setM31((matrix1.getM31() * matrix2.getM11()) + (matrix1.getM32() * matrix2.getM21()) + (matrix1.getM33() * matrix2.getM31()));
        result.setM32((matrix1.getM31() * matrix2.getM12()) + (matrix1.getM32() * matrix2.getM22()) + (matrix1.getM33() * matrix2.getM32()));
        result.setM33((matrix1.getM31() * matrix2.getM13()) + (matrix1.getM32() * matrix2.getM23()) + (matrix1.getM33() * matrix2.getM33()));

        return result;
    }
}
