/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;


/**
 *
 * @author htrefftz
 */
public class Vector4 {
    double [] vector;
    
    boolean DEBUG = true;
    
    /**
     * Constructor
     */
    public Vector4() {
        vector = new double[4];
        vector[3] = 1d;
    }
    
    public Vector4(double x, double y, double z) {
        vector = new double[4];
        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
        vector[3] = 1d;
    }

    /**
     *  Creates a vector based on the tail (x1, y1, z2) and the head(x2, y2, z2)
     * @param x1 tail
     * @param y1 tail
     * @param z1 tail
     * @param x2 head
     * @param y2 head
     * @param z2 head
     */
    public Vector4(double x1, double y1, double z1, double x2, double y2, double z2) {
        vector = new double[4];
        vector[0] = x2 - x1;
        vector[1] = y2 - y1;
        vector[2] = z2 - z1;
        vector[3] = 1d;
    }
    
    /**
     * Computes the cross product of V1 times V2
     * @param v1 vector 1
     * @param v2 vector 2
     * @return v1 x v2
     */
    public static Vector4 crossProduct(Vector4 v1, Vector4 v2) {
        double x = v1.getY() * v2.getZ() - v1.getZ() * v2.getY();
        double y = - (v1.getX() * v2.getZ() - v1.getZ() * v2.getX());
        double z = v1.getX() * v2.getY() - v1.getY() * v2.getX();
        return new Vector4(x, y, z);
    }
    
    /**
     * Computes the dot product of two vectors
     * @param v1 Vector1
     * @param v2 Vector2
     * @return 
     */
    public static double dotProduct(Vector4 v1, Vector4 v2) {
        return  v1.getX() * v2.getX() + v1.getY() * v2.getY() + 
                v1.getZ() * v2.getZ();
    }
    
    /**
     * Computes v1 - v2
     * @param v1 first vector
     * @param v2 second vector
     * @return v1 - v2
     */
    public static Vector4 subtract(Vector4 v1, Vector4 v2) {
        double x = v1.getX() - v2.getX();
        double y = v1.getY() - v2.getY();
        double z = v1.getZ() - v2.getZ();
        return new Vector4(x, y, z);
    }
    
    public static Vector4 minus(Vector4 v) {
        double x = - v.getX();
        double y = - v.getY();
        double z = - v.getZ();
        return new Vector4(x, y, z);
    }
    
    /**
     * Computes the magnitude of this vector
     * @return magnitude of the vector
     */
    public double magnitude() {
        return Math.sqrt(vector[0]*vector[0] + vector[1]*vector[1] + vector[2]*vector[2]);
    }
    
    public void normalize() {
        double mag = this.magnitude();
        vector[0] /= mag;
        vector[1] /= mag;
        vector[2] /= mag;
    }
    
    /**
     * Creates a new vector based on an existing vector
     * @param vector existing vector
     */
    public Vector4(double [] vector) {
        this.vector = vector;
    }
    
    /**
     * Normalizes the homogeneous coordinate, the last element should be 1
     */
    public void normalizeW() {
        if (vector[3] == 0) {
            return;
        }
        for(int i = 0; i < 4; i++) {
            vector[i] /= vector[3];
        }
    }
    
    /**
     * Returns the element at position pos 
     * @param pos
     * @return element at position pos
     */
    public double get(int pos) {
        return vector[pos];
    }
    
    /**
     * Returns the X coordinate
     * @return X coordinate
     */
    public double getX() {
        return vector[0];
    }
    
    /**
     * Returns the Y coordinate
     * @return Y coordinate
     */
    public double getY() {
        return vector[1];
    }
     /**
      * Returns the Z coordinate
      * @return Z coordinate
      */
    public double getZ() {
        return vector[2];
    }
    
    /**
     * Returns the W value
     * @return W value
     */
    public double getW() {
        return vector[3];
    }
    
   
    /**
     * Method to print a vector
     * @return the string with the elements of the vector
     */
    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < 4; i++) {
            s += vector[i] + " ";
        }
        return s;
    }
}
