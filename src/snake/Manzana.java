package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public final class Manzana extends Entidad {

    private final Random rnd = new Random();

    public Manzana() {
        reiniciar();
    }

    public void reiniciar() {
        setPosicion(rnd.nextInt(NUMERO_CELDAS) * TAM_CELDA, rnd.nextInt(NUMERO_CELDAS) * TAM_CELDA);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillRect(x + 1, y + 1, TAM_ENTIDAD, TAM_ENTIDAD);
    }
}
