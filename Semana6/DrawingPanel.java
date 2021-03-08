import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author jricaur1 y pcorream2
 */
public class DrawingPanel extends JPanel implements MouseListener, KeyListener {
    private JButton bAceptar;

    public static final int W = 500;
    public static final int H = 500;

    public static final int XMIN = 50;
    public static final int XMAX = 150;
    public static final int YMIN = 50;
    public static final int YMAX = 100;

    public static final int LEFT = 1; // 0001
    public static final int RIGHT = 2; // 0010
    public static final int BOTTOM = 4; // 0100
    public static final int TOP = 8; // 1000

    static Point[] points;
    static Edge[] lineSeg;

    int x1 = -1;
    int y1 = -1;
    int x2 = -1;
    int y2 = -1;

    int code1 = -1;
    int code2 = -1;

    /**
     * Constructor
     */
    public DrawingPanel() {
        add(getbAceptar());
        this.addMouseListener(this);
        this.addKeyListener(this);
    }

    /**
     * Paint the window
     * 
     * @param g Graphics context
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawAxis(g);
        drawObject(g);

        g.setColor(Color.BLUE);
        drawClippedLine(g);
    }

    /**
     * Draw the clipped line
     * 
     * @param g Graphics context
     */
    private void drawClippedLine(Graphics g) {
        if (code1 == 0 && code2 == 0) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.RED);
        }
        g.drawLine(toWindowX(x1), toWindowY(y1), toWindowX(x2), toWindowY(y2));
    }

    /**
     * Draw the X and Y axis
     * 
     * @param g Graphics context
     */
    private void drawAxis(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine(toWindowX(-100), toWindowY(0), toWindowX(100), toWindowY(0));
        g.setColor(Color.GREEN);
        g.drawLine(toWindowX(0), toWindowY(-100), toWindowX(0), toWindowY(100));
    }

    /**
     * Draw the clipping area in black
     * 
     * @param g Graphics context
     */
    private void drawObject(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < lineSeg.length; i++) {
            int x1 = lineSeg[i].getX1();
            int y1 = lineSeg[i].getY1();
            int x2 = lineSeg[i].getX2();
            int y2 = lineSeg[i].getY2();

            g.drawLine(toWindowX(x1), toWindowY(y1), toWindowX(x2), toWindowY(y2));
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {

            this.transponer(1);
        }
        if (key == KeyEvent.VK_A) {

            this.transponer(2);
        }
        if (key == KeyEvent.VK_S) {

            this.transponer(3);
        }
        if (key == KeyEvent.VK_D) {

            this.transponer(4);
        }
        if (key == KeyEvent.VK_I) {
            this.escalar(1.1);
        }
        if (key == KeyEvent.VK_K) {
            this.escalar(0.9);
        }
        if (key == KeyEvent.VK_Q) {
            this.rotar(false);
        }
        if (key == KeyEvent.VK_E) {
            this.rotar(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    private int toWindowX(int x) {
        return x + W / 2;
    }

    private int toWindowY(int y) {
        return H / 2 - y;
    }

    private JButton getbAceptar() {
        bAceptar = new JButton("Aceptar");
        // Acá es donde se le dice que escuche a las teclas
        bAceptar.addKeyListener(this);
        bAceptar.setBounds(10, 10, 100, 20);
        return bAceptar;
    }

    public void escalar(double escalar) {
        for (int i = 0; i < points.length; i++){
            double xAux = points[i].getX();
            double yAux = points[i].getY();
            points[i].setX((int)(xAux * escalar));
            points[i].setY((int)(yAux * escalar));
        }
        repaint();
    }

    public void rotar(boolean signo){
        double angle = 5;
        if (!signo){
            angle = -5; 
        }
        for (int i = 0; i < points.length; i++){
            int xTemp = points[i].getX();
            int yTemp = points[i].getY();
            double xAux = xTemp * Math.cos(angle) - yTemp * Math.sin(angle);
            double yAux = xTemp * Math.sin(angle) + yTemp * Math.cos(angle);
            points[i].setX((int)(xAux));
            points[i].setY((int)(yAux));
        }
        repaint();
    }

    public void transponer(int direction) {
        // Derecha
        if (direction == 4) {
            for (int i = 0; i < points.length; i++) {
                points[i].setX((points[i].getX() + 20));
            }
            repaint();
        }
        // Abajo
        else if (direction == 2) {
            for (int i = 0; i < points.length; i++) {
                points[i].setX((points[i].getX() - 20));
            }
            repaint();
        }
        // Izquierda
        else if (direction == 3) {
            for (int i = 0; i < points.length; i++) {
                points[i].setY((points[i].getY() - 20));
            }
            repaint();
        }
        // Arriba
        else if (direction == 1) {
            for (int i = 0; i < points.length; i++) {
                points[i].setY((points[i].getY() + 20));
            }
            repaint();
        }
    }

    /**
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    private int computeCode(int x, int y) {
        int code = 0;
        if (x < XMIN)
            code |= LEFT;
        if (x > XMAX)
            code |= RIGHT;
        if (y < YMIN)
            code |= BOTTOM;
        if (y > YMAX)
            code |= TOP;
        return code;
    }

    public void setPoints() {

    }

    /**
     * Main program
     * 
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        File file = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String[] xy = new String[3];

        String currentLine = br.readLine();
        int qPoints = Integer.parseInt(currentLine);
        points = new Point[qPoints];
        for (int i = 0; i < qPoints; i++) {
            currentLine = br.readLine();
            xy = currentLine.split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            int z = Integer.parseInt(xy[2]);
            double d = -1000;
            double xp = x/(z/d);
            double yp = y/(z/d);
            points[i] = new Point((int)xp,(int) yp);
        }
        currentLine = br.readLine();
        int qLines = Integer.parseInt(currentLine);
        lineSeg = new Edge[qLines];
        String[] edges = new String[2];
        for (int i = 0; i < qLines; i++) {
            currentLine = br.readLine();
            edges = currentLine.split(" ");
            int eg1 = Integer.parseInt(edges[0]);
            int eg2 = Integer.parseInt(edges[1]);
            lineSeg[i] = new Edge(points[eg1], points[eg2]);
        }

        // Crear un nuevo Frame

        JFrame frame = new JFrame("Drawing Panel");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Points (esta clase)
        DrawingPanel clip = new DrawingPanel();
        frame.add(clip);
        // frame.addMouseListener(ev);
        // Asignarle tamaño
        frame.setSize(W, H);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);
        br.close();
    }

}