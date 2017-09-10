package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Cuerpo extends Entidad implements Constantes{

    private int xAnterior;
    private int yAnterior;


    public Cuerpo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void mueve() {
        xAnterior = x;
        yAnterior = y;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN.brighter());
        g2d.fillRect(x + 1, y + 1, TAM_ENTIDAD, TAM_ENTIDAD);
    }

    public int getxAnterior() {
        return xAnterior;
    }

    public int getyAnterior() {
        return yAnterior;
    }
}
