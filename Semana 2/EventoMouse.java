/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 *
 * @author htrefftz
 */

public class EventoMouse extends JPanel implements MouseListener {
    
  static int INSIDE = 0;
  static int LEFT = 1;
  static int RIGHT = 2;
  static int BOTTOM = 4;
  static int TOP = 8;
  boolean adentro;

  public int ComputeOutCode(double x, double y){
      int code = INSIDE;

      if(x < 100){
          code += LEFT;
      } else if (x > 300) {
          code += RIGHT;
      }
      if(y < 100){
          code += BOTTOM;
      } else if (y > 300) {
          code += TOP;
      }
      return code;
  }

  public boolean CohenSutherland(double x0, double x1, double y0, double y1){
      int outCode0 = ComputeOutCode(x0, y0);
      int outCode1 = ComputeOutCode(x1, y1);
      
      boolean accept = false;

      while(true){
          if((outCode0 & outCode1) == 0){
              accept = true;
              break;
          } else if((outCode0 & outCode1) != 0){
              break;
          }
      }
      adentro = accept;
      return adentro;

  }
      
    Line2D.Double linea1;
    
    public EventoMouse() {
        linea1 = new Line2D.Double();
        this.addMouseListener(this);
    }

    @Override
  public void paintComponent(Graphics g) {
      super.paintComponent(g);

      Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(Color.YELLOW);
      g2d.drawRect(100, 100, 200, 200);
      if(adentro==true){
        g2d.setColor(Color.BLUE);
      }
      else
        g2d.setColor(Color.RED);

      g2d.draw(linea1);

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
      boolean result = CohenSutherland(linea1.x1, linea1.x2, linea1.y1, linea1.y2);
      System.out.println(result);
      repaint();
  }

  public static void main(String[] args) {
      // Crear un nuevo Frame
      JFrame frame = new JFrame("Eventos del Mouse");
      // Al cerrar el frame, termina la ejecución de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Agregar un JPanel que se llama Points (esta clase)
      EventoMouse ev = new EventoMouse();
      frame.add(ev);
      //frame.addMouseListener(ev);
      // Asignarle tamaño
      frame.setSize(500, 500);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
  }

    
}
