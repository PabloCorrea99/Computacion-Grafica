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
public class Uvn extends Matrix4x4  {
    Vector4 from;
    Vector4 lookAt;
    Vector4 up;

    public Uvn() {
        super();
    }
    
    public Uvn(Vector4 from, Vector4 lookAt, Vector4 up) {
        // For the time being, create an identity matrix
        super();
        
    }
    
    
}
