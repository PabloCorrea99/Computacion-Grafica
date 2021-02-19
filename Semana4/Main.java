import Matrix3x3;
import Point3;

public class Main{
    public static void main(String[] args) {
        Point3 punto = new Point3(3,3,1);
        Matrix3x3 matriz1 = new Matrix3x3(1,0,2,0,1,0,0,0,1);
        Matrix3x3 matriz2 = new Matrix3x3(1,0,1,0,1,0,0,0,1);

        Point3 resultP = Matrix3x3.times(matriz1, punto);
        System.out.println(resultP.getX());
        System.out.println(resultP.getY());
        System.out.println(resultP.getW());


        Matrix3x3 result = Matrix3x3.times(matriz1, matriz2);
        System.out.println(result.getM11() + " | " + result.getM12() + " | " + result.getM13());
        System.out.println(result.getM21() + " | " + result.getM22() + " | " + result.getM23());
        System.out.println(result.getM31() + " | " + result.getM32() + " | " + result.getM33());

    }
}