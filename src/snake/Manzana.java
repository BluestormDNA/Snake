package snake;

import java.awt.Color;
import java.util.Random;

public final class Manzana extends Entidad {

    private final Random rnd = new Random();

    public Manzana() {
        color = Color.RED;
        reiniciar();
    }

    public void reiniciar() {
        setPosicion(rnd.nextInt(NUMERO_CELDAS) * TAM_CELDA, rnd.nextInt(NUMERO_CELDAS) * TAM_CELDA);
    }
    
}
