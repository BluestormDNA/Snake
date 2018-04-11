package snake;

import java.awt.Color;

public class Cuerpo extends Entidad {

    public Cuerpo(int x, int y) {
        this.x = x;
        this.y = y;
        color = Color.GREEN.darker();
    }
}
