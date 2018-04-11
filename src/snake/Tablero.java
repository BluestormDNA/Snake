package snake;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tablero extends JPanel implements Constantes {
    
    private final Serpiente serpiente;
    private final Manzana manzana;
    private final Marcador marcador;
    
    public Tablero() {
        serpiente = new Serpiente();
        manzana = new Manzana();
        marcador = new Marcador();
        
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                serpiente.keyPressed(e);
            }
        });
        setFocusable(true);
    }
    
    public static void main(String[] args) throws InterruptedException {
        JFrame ventana = new JFrame("Snake clon");
        Tablero tablero = new Tablero();
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.add(tablero);
        ventana.setVisible(true);
        
        while (true) {
            tablero.actualizar();
            tablero.repaint();
            Thread.sleep(200);
        }
    }
    
    private void actualizar() {
        serpiente.mueve();
        if (colisionManzana()) {
            manzana.reiniciar();
            serpiente.addCuerpo();
            marcador.setPunto();
        } else if (colisionSerpiente() || colisionEscenario()) {
            marcador.reiniciar();
            serpiente.reiniciar();
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        dibujarTablero(g);
        manzana.paint(g);
        serpiente.paint(g);
        marcador.paint(g);
    }
    
    public boolean colisionManzana() {
        return serpiente.getX() == manzana.getX() && serpiente.getY() == manzana.getY();
    }
    
    private boolean colisionSerpiente() {
        for (Cuerpo c : serpiente.getCuerpo()) {
            if (serpiente.getX() == c.getX() && serpiente.getY() == c.getY()) {
                if (c != serpiente.getCuerpo().get(0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean colisionEscenario() {
        return serpiente.getX() < 0 || serpiente.getX() >= TAM_TABLERO || serpiente.getY() < 0 || serpiente.getY() >= TAM_TABLERO;
    }
    
    private void dibujarTablero(Graphics g) {
        for (int x = 0; x <= TAM_TABLERO; x += TAM_CELDA) {
            g.drawLine(x, 0, x, TAM_TABLERO);
        }
        for (int y = 0; y <= TAM_TABLERO; y += TAM_CELDA) {
            g.drawLine(0, y, TAM_TABLERO, y);
        }
    }
    
}
