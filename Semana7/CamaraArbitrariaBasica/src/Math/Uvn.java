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
        Matrix4x4 matrixM = new Matrix4x4();
        //Calculate N = lookAt - from
        Vector4 N = new Vector4();
        N = (Vector4.substract(lookAt,from));
        //Normalize N
        Vector4 n = N.normalize();

        //Calculate u=Vxn normalized
        Vector4 u = new Vector4();
        u = (Vector4.crossProduct(up, n));
        u = u.normalize();

        //Calculate v=nxu
        Vector4 v = new Vector4();
        v = (Vector4.crossProduct(n, u));
        
        matrixM.set(0,0,u.getX());
        matrixM.set(0,1,u.getY()); 
        matrixM.set(0,2,u.getZ());
        matrixM.set(0,3,Vector4.dotProduct(u.minus(), from));

        matrixM.set(1,0,v.getX());
        matrixM.set(1,1,v.getY());
        matrixM.set(1,2,v.getZ()); 
        matrixM.set(1,3,Vector4.dotProduct(v.minus(), from));

        matrixM.set(2,0,n.getX());
        matrixM.set(2,1,n.getY());
        matrixM.set(2,2,n.getZ());
        matrixM.set(2,3,Vector4.dotProduct(n.minus(), from));

        matrixM.set(3,0,0); 
        matrixM.set(3,1,0);
        matrixM.set(3,2,0);
        matrixM.set(3,3,1);
        
    }
    
    
}
