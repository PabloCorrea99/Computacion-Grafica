package Geometry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Math.Vector4;

/**
 * This class handles the edges that compose an object
 * @author htrefftz
 */
public class Edge {
    Vector4 start;
    Vector4 end;

    /**
     * Constructor
     * @param start start Vertex
     * @param fin end Vertex
     */
    public Edge(Vector4 start, Vector4 fin) {
        this.start = start;
        this.end = fin;
    }
    
    @Override
    public String toString() {
        String s = "Edge ";
        s += "start " + start.toString() + "end " + end.toString();
        return s;
    }
}
