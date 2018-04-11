package snake;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public final class Serpiente implements Constantes {

    private enum dir {
        ARRIBA, IZQUIERDA, ABAJO, DERECHA;
    }
    private dir direccion = dir.DERECHA;

    private final ArrayList<Cuerpo> cuerpo = new ArrayList<>();

    public Serpiente() {
        reiniciar();
    }

    public void reiniciar() {
        cuerpo.clear();
        cuerpo.add(new Cuerpo(10 * TAM_CELDA, 10 * TAM_CELDA));
    }

    public void mueve() {
        this.mueveCuerpo();

        if (direccion == dir.ARRIBA) {
            cuerpo.get(0).setY(cuerpo.get(0).getY() - TAM_CELDA);
        }
        if (direccion == dir.DERECHA) {
            cuerpo.get(0).setX(cuerpo.get(0).getX() + TAM_CELDA);
        }
        if (direccion == dir.ABAJO) {
            cuerpo.get(0).setY(cuerpo.get(0).getY() + TAM_CELDA);
        }
        if (direccion == dir.IZQUIERDA) {
            cuerpo.get(0).setX(cuerpo.get(0).getX() - TAM_CELDA);
        }
    }

    public void paint(Graphics g) {
        for (Cuerpo c : cuerpo) {
            c.paint(g);
        }
    }

    void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if (direccion != dir.ABAJO) {
                    direccion = dir.ARRIBA;
                }
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if (direccion != dir.DERECHA) {
                    direccion = dir.IZQUIERDA;
                }
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if (direccion != dir.ARRIBA) {
                    direccion = dir.ABAJO;
                }
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if (direccion != dir.IZQUIERDA) {
                    direccion = dir.DERECHA;
                }
                break;
            default:
        }
    }

    void addCuerpo() {
        cuerpo.add(new Cuerpo(cuerpo.get(0).getX(), cuerpo.get(0).getY()));
    }

    private void mueveCuerpo() {
        for (int i = cuerpo.size() - 1; i > 0; i--) {
            cuerpo.get(i).setPosicion(cuerpo.get(i - 1).x, cuerpo.get(i - 1).y);
        }
    }

    public ArrayList<Cuerpo> getCuerpo() {
        return cuerpo;
    }

    public int getX() {
        return cuerpo.get(0).getX();
    }

    public int getY() {
        return cuerpo.get(0).getY();
    }
}
