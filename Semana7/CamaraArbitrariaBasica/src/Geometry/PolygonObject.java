package Geometry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import Math.Matrix4x4;
import Math.Vector4;

/**
 * This class handles a collection of edges that form the object to be drawn
 * @author htrefftz
 */
public class PolygonObject {
    ArrayList<Edge> edges;
    
    boolean DEBUG = false;

    /**
     * Constructor
     */
    public PolygonObject() {
        edges = new ArrayList<>();
    }
    
    /**
     * Add an edge to the collection of edges
     * @param edge edge to be added
     */
    public void addEdge(Edge edge) {
        edges.add(edge);
    }
    
    /**
     * Draw the lines composing the polygon
     * @param dc JPanel to draw the object on
     */
    public void drawObject(DibujarCasita3D dc) {
        for(Edge edge: edges) {
            drawOneLine(dc, edge);
        }
    }

    public void drawObject(Main2 dc) {
        for(Edge edge: edges) {
            drawOneLine(dc, edge);
        }
    }


    
    /**
     * Ask the JPanel to draw one of the edges composing the object
     * @param dc JPanel to draw on
     * @param edge Edge to draw
     */
    public void drawOneLine(DibujarCasita3D dc, Edge edge) {
        int x1 = (int)edge.start.getX();
        int y1 = (int)edge.start.getY();
        int x2 = (int)edge.end.getX();
        int y2 = (int)edge.end.getY();
        
        dc.drawOneLine(x1, y1, x2, y2);
    }

    public void drawOneLine(Main2 dc, Edge edge) {
        int x1 = (int)edge.start.getX();
        int y1 = (int)edge.start.getY();
        int x2 = (int)edge.end.getX();
        int y2 = (int)edge.end.getY();
        
        dc.drawOneLine(x1, y1, x2, y2);
    }
    
    
    /**
     * Transform an object given a transformation.
     * The vertices of the object are transformed.
     * @param transformation 
     */
    public void transformObject(Matrix4x4 transformation) {
        for(Edge e: edges) {
            if(DEBUG)
                System.out.println("Before: " + e);
            e.start = Matrix4x4.times(transformation, e.start);
            e.end   = Matrix4x4.times(transformation, e.end);
            if(DEBUG)
                System.out.println("After: " + e);
        }
    }
    
    public static PolygonObject transformObject(PolygonObject po, 
            Matrix4x4 transformation) {
        
        PolygonObject newObject = new PolygonObject();
        for(Edge e: po.edges) {
            Vector4 newStart = Matrix4x4.times(transformation, e.start);
            Vector4 newEnd = Matrix4x4.times(transformation, e.end);
            Edge newEdge = new Edge(newStart, newEnd);
            newObject.addEdge(newEdge);
        }
        return newObject; 
    }
}
