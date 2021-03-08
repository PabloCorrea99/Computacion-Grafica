/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

/**
 * This class handles 4x4 matrices, used to store transformations.
 * Individual transformations (translations, scaling, rotation, etc.
 * inherit from this class.
 * @author htrefftz
 */
public class Matrix4x4 {
    
    protected double [][] matrix;
    
    /**
     * Construct a matrix.
     * By default, the identity matrix
     */
    public Matrix4x4() {
        matrix = new double [4][4];
        for(int i = 0; i < 4; i++) {
            matrix[i][i] = 1d;
        }
    }
    
    /**
     * Constructor. Receives a 4x4 double matrix
     * @param matrix 4x4 double matrix
     */
    public Matrix4x4(double [][] matrix) {
        this.matrix = matrix;
    }
    
    /**
     * Set an element of the matrix
     * @param row row of the element to set
     * @param col column of the element to set
     * @param value value to store
     */
    public void set(int row, int col, double value) {
        matrix[row][col] = value;
    }
    
    /**
     * Returns a particular element of the matrix
     * @param row row of the element to be returned
     * @param col column of the element to be returned
     * @return element at position [row][col]
     */
    public double get(int row, int col) {
        return matrix[row][col];
    }
    
    /**
     * This method multiplies a Matrix4x4 times a Vector4
     * @param matrix Matrix that is pre-multipliead by the column vector
     * @param vector Vector that is multiplied by the matrix
     * @return 
     */
    public static Vector4 times(Matrix4x4 matrix, Vector4 vector) {
        double [] newVector = new double[4];
        for(int i = 0; i < 4; i++) {
            double acum = 0;
            for(int j = 0; j < 4; j++) {
                acum += matrix.get(i,j)*vector.get(j);
            }
            newVector[i] = acum;
        }
        double w = newVector[3];
        if(w != 1) {
            for(int i = 0; i < 4; i++) {
                newVector[i] = newVector[i]/w;
            }
        }
        return new Vector4(newVector);
    }
    
    /**
     * This method multiplies a Matrix4x4 by another Matrix4x4 and returns
     * the result
     * @param m1 First 4x4 matrix
     * @param m2 Second 4x4 matrix
     * @return new 4x4 matrix with the result
     */
    public static Matrix4x4 times(Matrix4x4 m1, Matrix4x4 m2) {
        double [][] newMatrix = new double[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                double acum = 0;
                for(int k = 0; k < 4; k++) {
                    acum += m1.get(i, k) * m2.get(k, j);
                }
                newMatrix[i][j] = acum;
            }
        }
        return new Matrix4x4(newMatrix);
    }
    
    /**
     * Method to print a matrix
     * @return 
     */
    @Override
    public String toString() {
        String retString = "";
        for(int row = 0; row < 4; row++) {
            for(int col = 0; col < 4; col++) {
                retString += matrix[row][col] + " ";
            }
            retString += "\n";
        }
        return retString;
    }
    
    public static void main(String [] args) {
        // Test multiplication
        System.out.println("Matrix-Vector multiplication");
        Matrix4x4 m1 = new Matrix4x4();
        Vector4 v1 = new Vector4();
        Vector4 v2 = Matrix4x4.times(m1, v1);
        System.out.println(v2);
        
        // Test Translation
        /*
        System.out.println("Translation");
        Translation t1 = new Translation(10d, 20d, 30d);
        Translation t2 = new Translation(-10d, -20d, -30d);
        System.out.println(Matrix4x4.times(t1, t2));
        */
    }
}
