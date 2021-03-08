/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import java.util.Vector;

/**
 *
 * @author htrefftz
 */
public class Uvn extends Matrix4x4  {
    Vector4 from;
    Vector4 lookAt;
    Vector4 up;

    public Uvn() {
        super();
    }
    
    public Uvn(Vector4 from, Vector4 lookAt, Vector4 up) {
        super();
        // For the time being, create an identity matrix
        
        //Calculate N = lookAt - from
        Vector4 N = new Vector4();
        N = (Vector4.subtract(from,lookAt));
        //Normalize N
        N.normalize();

        //Calculate u=Vxn normalized
        Vector4 u = new Vector4();
        u = (Vector4.crossProduct(up, N));
        u.normalize();

        //Calculate v=nxu
        Vector4 v = new Vector4();
        v = (Vector4.crossProduct(N, u));


        matrix[0][0] = u.getX();
        matrix[0][1] = u.getY(); 
        matrix[0][2] = u.getZ();
        matrix[0][3] = Vector4.dotProduct(Vector4.minus(u), from);

        matrix[1][0] = v.getX();
        matrix[1][1] = v.getY(); 
        matrix[1][2] = v.getZ();
        matrix[1][3] = Vector4.dotProduct(Vector4.minus(v), from);

        matrix[2][0] = N.getX();
        matrix[2][1] = N.getY(); 
        matrix[2][2] = N.getZ();
        matrix[2][3] = Vector4.dotProduct(Vector4.minus(N), from);

        matrix[3][0] = 0;
        matrix[3][1] = 0;
        matrix[3][2] = 0;
        matrix[3][3] = 1;
        
    }
    
    
}
