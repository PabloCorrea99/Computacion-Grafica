
/**
 * Clase para dibujar una linea
 * 
 * @author Pablo Correa y Julian Ricaurte
 * @version Febrero 2021
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.geom.Line2D;
    
public class Puntos extends JPanel implements MouseListener
{
    private final int pixelSize = 1;
    Line2D.Double linea1;

    public Puntos (){
        linea1 = new Line2D.Double();
        this.addMouseListener(this);  
    }

    @Override 
    public void mouseClicked(MouseEvent e) {}
    
      @Override
    public void mouseEntered(MouseEvent e) {}
  
      @Override
    public void mouseExited(MouseEvent e) {}
  
      @Override
    public void mousePressed(MouseEvent e) {
        linea1.x1 = e.getX();
        linea1.y1 = e.getY();
    }
  
      @Override
    public void mouseReleased(MouseEvent e) {
        linea1.x2 = e.getX();
        linea1.y2 = e.getY();    
        repaint();
    }
 
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLine(g, (int)linea1.x1, (int)linea1.x2, (int)linea1.y1, (int)linea1.y2); 

    }
 
    private void plot(Graphics g, int x, int y) {
        int w = (getWidth() - 1) / pixelSize;
        int h = (getHeight() - 1) / pixelSize;
        int maxX = (w - 1) / 2;
        int maxY = (h - 1) / 2;
 
        int borderX = getWidth() - ((2 * maxX + 1) * pixelSize + 1);
        int borderY = getHeight() - ((2 * maxY + 1) * pixelSize + 1);
        int left = (x) * pixelSize + borderX / 2;
        int top = (y) * pixelSize + borderY / 2;
 
        g.setColor(Color.BLACK);
        g.drawOval(left, top, pixelSize, pixelSize);
    }
 
    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        // delta of exact value and rounded value of the dependent variable
        int d = 0;
 
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
 
        int dx2 = 2 * dx; // slope scaling factors to
        int dy2 = 2 * dy; // avoid floating point
 
        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;
 
        int x = x1;
        int y = y1;
 
        if (dx >= dy) {
            while (true) {
                plot(g, x, y);
                if (x == x2)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                plot(g, x, y);
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }
    }

  public static void main(String[] args) {
      // Crear un nuevo Frame
      JFrame frame = new JFrame("Puntos");
      // Al cerrar el frame, termina la ejecución de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Agregar un JPanel que se llama Points (esta clase)
      frame.add(new Puntos());
      // Asignarle tamaño
      frame.setSize(500, 500);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
      
  }
    
}
