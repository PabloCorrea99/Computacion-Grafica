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
public class Translation extends Matrix4x4 {
    
    public Translation() {
        super();
    }
    
    public Translation(double dx, double dy, double dz) {
        super();
        matrix[0][3] = dx;
        matrix[1][3] = dy;
        matrix[2][3] = dz;
    }
}
