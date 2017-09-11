package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static snake.Constantes.TAM_ENTIDAD;

public class Entidad implements Constantes {

    protected int x;
    protected int y;
    protected Color color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPosicion(int x, int y) {
        setX(x);
        setY(y);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.fillRect(x + 1, y + 1, TAM_ENTIDAD, TAM_ENTIDAD);
    }
}
