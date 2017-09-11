package snake;

import java.awt.Color;

public class Cuerpo extends Entidad implements Constantes{

    private int xAnterior;
    private int yAnterior;

    public Cuerpo(int x, int y) {
        this.x = x;
        this.y = y;
        color = Color.GREEN.brighter();
    }

    public void mueve() {
        xAnterior = x;
        yAnterior = y;
    }

    public int getxAnterior() {
        return xAnterior;
    }

    public int getyAnterior() {
        return yAnterior;
    }
}
