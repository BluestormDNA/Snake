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
            tablero.repaint();
            tablero.mueve();
            Thread.sleep(200);
        }
    }

    private void mueve() {
        serpiente.mueve();
        this.compruebaColisionManzana();
        this.compruebaColisionSerpiente();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int x = 0; x <= TAM_TABLERO; x += TAM_CELDA) {
            g.drawLine(x, 0, x, TAM_TABLERO);
        }
        for (int y = 0; y <= TAM_TABLERO; y += TAM_CELDA) {
            g.drawLine(0, y, TAM_TABLERO, y);
        }

        manzana.paint(g);
        serpiente.paint(g);
        marcador.paint(g);

    }

    public void compruebaColisionManzana() {
        if (serpiente.getX() == manzana.getX() && serpiente.getY() == manzana.getY()) {
            manzana.reiniciar();
            serpiente.addCuerpo();
            marcador.setPunto();
        }
    }

    private void compruebaColisionSerpiente() {
        boolean colision = false;
        for (Cuerpo c : serpiente.getCuerpo()) {
            if (serpiente.getX() == c.getX() && serpiente.getY() == c.getY()) {
                colision = true;
            }
        }
        
        if (serpiente.getX() < 0 || serpiente.getX() >= TAM_TABLERO || serpiente.getY() < 0 || serpiente.getY() >= TAM_TABLERO) {
            colision = true;
        }

        if (colision) {
            marcador.reiniciar();
            serpiente.reiniciar();
        }
    }
}
