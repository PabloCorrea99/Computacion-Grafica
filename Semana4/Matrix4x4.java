
public class Matrix4x4 {
    private double m11;
    private double m12;
    private double m13;
    private double m14;
    private double m21;
    private double m22;
    private double m23;
    private double m24;
    private double m31;
    private double m32;
    private double m33;
    private double m34;
    private double m41;
    private double m42;
    private double m43;
    private double m44;

    public Matrix4x4(double m11, double m12, double m13, double m14, double m21, double m22, double m23, double m24,
            double m31, double m32, double m33, double m34, double m41, double m42, double m43, double m44) {
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m14 = m14;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m24 = m24;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        this.m34 = m34;
        this.m41 = m41;
        this.m42 = m42;
        this.m43 = m43;
        this.m44 = m44;
    }

    public Matrix4x4() {
        this.m11 = 0;
        this.m12 = 0;
        this.m13 = 0;
        this.m14 = 0;
        this.m21 = 0;
        this.m22 = 0;
        this.m23 = 0;
        this.m24 = 0;
        this.m31 = 0;
        this.m32 = 0;
        this.m33 = 0;
        this.m34 = 0;
        this.m41 = 0;
        this.m42 = 0;
        this.m43 = 0;
        this.m44 = 0;
    }

    public double getM11() {
        return m11;
    }

    public double getM12() {
        return m12;
    }

    public double getM13() {
        return m13;
    }

    public double getM14() {
        return m14;
    }

    public double getM21() {
        return m21;
    }

    public double getM22() {
        return m22;
    }

    public double getM23() {
        return m23;
    }

    public double getM24() {
        return m24;
    }

    public double getM31() {
        return m31;
    }

    public double getM32() {
        return m32;
    }

    public double getM33() {
        return m33;
    }

    public double getM34() {
        return m34;
    }

    public double getM41() {
        return m41;
    }

    public double getM42() {
        return m42;
    }

    public double getM43() {
        return m43;
    }

    public double getM44() {
        return m44;
    }

    public void setM11(double m11) {
        this.m11 = m11;
    }

    public void setM12(double m12) {
        this.m12 = m12;
    }

    public void setM13(double m13) {
        this.m13 = m13;
    }

    public void setM14(double m14) {
        this.m14 = m14;
    }

    public void setM21(double m21) {
        this.m21 = m21;
    }

    public void setM22(double m22) {
        this.m22 = m22;
    }

    public void setM23(double m23) {
        this.m23 = m23;
    }

    public void setM24(double m24) {
        this.m24 = m24;
    }

    public void setM31(double m31) {
        this.m31 = m31;
    }

    public void setM32(double m32) {
        this.m32 = m32;
    }

    public void setM33(double m33) {
        this.m33 = m33;
    }

    public void setM34(double m34) {
        this.m34 = m34;
    }

    public void setM41(double m41) {
        this.m41 = m41;
    }

    public void setM42(double m42) {
        this.m42 = m42;
    }

    public void setM43(double m43) {
        this.m43 = m43;
    }

    public void setM44(double m44) {
        this.m44 = m44;
    }

    public static Point4 times(Matrix4x4 matrix, Point4 point) {
        Point4 result = new Point4();
        result.setX((matrix.getM11() * point.getX()) + (matrix.getM12() * point.getY())
                + (matrix.getM13() * point.getW()) + (matrix.getM14() * point.getZ()));
        result.setY((matrix.getM21() * point.getX()) + (matrix.getM22() * point.getY())
                + (matrix.getM23() * point.getW()) + (matrix.getM24() * point.getZ()));
        result.setW((matrix.getM31() * point.getX()) + (matrix.getM32() * point.getY())
                + (matrix.getM33() * point.getW()) + (matrix.getM34() * point.getZ()));
        result.setZ((matrix.getM41() * point.getX()) + (matrix.getM42() * point.getY())
                + (matrix.getM43() * point.getW()) + (matrix.getM44() * point.getZ()));
        System.out.println(result.getX());
        System.out.println(result.getY());
        System.out.println(result.getW());
        System.out.println(result.getZ());

        return result;
    }

    public static Matrix4x4 times(Matrix4x4 matrix1, Matrix4x4 matrix2) {
        Matrix4x4 result = new Matrix4x4();
        // Fila 1
        result.setM11((matrix1.getM11() * matrix2.getM11()) + (matrix1.getM12() * matrix2.getM21())
                + (matrix1.getM13() * matrix2.getM31()) + (matrix1.getM14() * matrix2.getM41()));
        result.setM12((matrix1.getM11() * matrix2.getM12()) + (matrix1.getM12() * matrix2.getM22())
                + (matrix1.getM13() * matrix2.getM32()) + (matrix1.getM14() * matrix2.getM42()));
        result.setM13((matrix1.getM11() * matrix2.getM13()) + (matrix1.getM12() * matrix2.getM23())
                + (matrix1.getM13() * matrix2.getM33()) + (matrix1.getM14() * matrix2.getM43()));
        result.setM14((matrix1.getM11() * matrix2.getM14()) + (matrix1.getM12() * matrix2.getM24())
                + (matrix1.getM13() * matrix2.getM34()) + (matrix1.getM14() * matrix2.getM44()));
        // Fila 2
        result.setM21((matrix1.getM21() * matrix2.getM11()) + (matrix1.getM22() * matrix2.getM21())
                + (matrix1.getM23() * matrix2.getM31()) + (matrix1.getM24() * matrix2.getM41()));
        result.setM22((matrix1.getM21() * matrix2.getM12()) + (matrix1.getM22() * matrix2.getM22())
                + (matrix1.getM23() * matrix2.getM32()) + (matrix1.getM24() * matrix2.getM42()));
        result.setM23((matrix1.getM21() * matrix2.getM13()) + (matrix1.getM22() * matrix2.getM23())
                + (matrix1.getM23() * matrix2.getM33()) + (matrix1.getM24() * matrix2.getM43()));
        result.setM24((matrix1.getM21() * matrix2.getM14()) + (matrix1.getM22() * matrix2.getM24())
                + (matrix1.getM23() * matrix2.getM34()) + (matrix1.getM24() * matrix2.getM44()));
        // Fila 3
        result.setM31((matrix1.getM31() * matrix2.getM11()) + (matrix1.getM32() * matrix2.getM21())
                + (matrix1.getM33() * matrix2.getM31()) + (matrix1.getM34() * matrix2.getM41()));
        result.setM32((matrix1.getM31() * matrix2.getM12()) + (matrix1.getM32() * matrix2.getM22())
                + (matrix1.getM33() * matrix2.getM32()) + (matrix1.getM34() * matrix2.getM42()));
        result.setM33((matrix1.getM31() * matrix2.getM13()) + (matrix1.getM32() * matrix2.getM23())
                + (matrix1.getM33() * matrix2.getM33()) + (matrix1.getM34() * matrix2.getM43()));
        result.setM34((matrix1.getM31() * matrix2.getM14()) + (matrix1.getM32() * matrix2.getM24())
                + (matrix1.getM33() * matrix2.getM34()) + (matrix1.getM34() * matrix2.getM44()));
        // Fila 4
        result.setM41((matrix1.getM41() * matrix2.getM11()) + (matrix1.getM42() * matrix2.getM21())
                + (matrix1.getM43() * matrix2.getM31()) + (matrix1.getM44() * matrix2.getM41()));
        result.setM42((matrix1.getM41() * matrix2.getM12()) + (matrix1.getM42() * matrix2.getM22())
                + (matrix1.getM43() * matrix2.getM32()) + (matrix1.getM44() * matrix2.getM42()));
        result.setM43((matrix1.getM41() * matrix2.getM13()) + (matrix1.getM42() * matrix2.getM23())
                + (matrix1.getM43() * matrix2.getM33()) + (matrix1.getM44() * matrix2.getM43()));
        result.setM44((matrix1.getM41() * matrix2.getM14()) + (matrix1.getM42() * matrix2.getM24())
                + (matrix1.getM43() * matrix2.getM34()) + (matrix1.getM44() * matrix2.getM44()));

        System.out
                .println(result.getM11() + " | " + result.getM12() + " | " + result.getM13() + " | " + result.getM14());
        System.out
                .println(result.getM21() + " | " + result.getM22() + " | " + result.getM23() + " | " + result.getM24());
        System.out
                .println(result.getM31() + " | " + result.getM32() + " | " + result.getM33() + " | " + result.getM34());
        System.out
                .println(result.getM41() + " | " + result.getM42() + " | " + result.getM43() + " | " + result.getM44());

        return result;
    }
}
