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
public class Projection extends Matrix4x4 {
    
    public Projection() {
        super();
    }
    
    public Projection(double d) {
        super();
        matrix[3][2] = 1/d;
        matrix[3][3] = 0;
    }
}
