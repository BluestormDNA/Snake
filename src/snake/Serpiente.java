package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public final class Serpiente extends Entidad {

    private int xAnterior;
    private int yAnterior;
    private enum dir{
        ARRIBA,IZQUIERDA,ABAJO,DERECHA;
    }
    private dir direccion = dir.DERECHA;
    private dir direccionPrevia;

    private final ArrayList<Cuerpo> cuerpo = new ArrayList<>();

    public Serpiente() {
        reiniciar();
        color = Color.GREEN.darker();
    }

    public void reiniciar() {
        setPosicion(10 * TAM_CELDA, 10 * TAM_CELDA);
        cuerpo.clear();
    }

    public void mueve() {
        xAnterior = x;
        yAnterior = y;

        if (direccion == dir.ARRIBA) {
            y += -TAM_CELDA;
        }
        if (direccion == dir.DERECHA) {
            x += TAM_CELDA;
        }
        if (direccion == dir.ABAJO) {
            y += TAM_CELDA;
        }
        if (direccion == dir.IZQUIERDA) {
            x += -TAM_CELDA;
        }
        this.mueveCuerpo();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Cuerpo c : cuerpo) {
            c.paint(g);
        }
    }

    void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if (direccionPrevia != dir.ABAJO) {
                    direccion = dir.ARRIBA;
                }
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if (direccionPrevia != dir.DERECHA) {
                    direccion = dir.IZQUIERDA;
                }
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if (direccionPrevia != dir.ARRIBA) {
                    direccion = dir.ABAJO;
                }
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if (direccionPrevia != dir.IZQUIERDA) {
                    direccion = dir.DERECHA;
                }
                break;
            default:
        }
        direccionPrevia = direccion;
    }

    void addCuerpo() {
        cuerpo.add(new Cuerpo(xAnterior, yAnterior));
    }

    private void mueveCuerpo() {
        if (cuerpo.size() > 0) {
            Cuerpo c = cuerpo.get(0);
            c.setPosicion(xAnterior, yAnterior);
        }
        avanzaArrayCuerpo();
    }

    private void avanzaArrayCuerpo() {
        for (int i = 1; i < cuerpo.size(); i++) {
            Cuerpo c = cuerpo.get(i);
            Cuerpo cAnterior = cuerpo.get(i - 1);
            c.setPosicion(cAnterior.getxAnterior(),cAnterior.getyAnterior());
        }
        for (Cuerpo c : cuerpo) {
            c.mueve();
        }
    }

    public ArrayList<Cuerpo> getCuerpo() {
        return cuerpo;
    }
}
