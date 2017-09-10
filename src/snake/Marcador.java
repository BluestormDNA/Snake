package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Marcador {

    private int puntuacion;
    private int max;

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GREEN.darker().darker());
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString("Snake ", 580, 50);
        g2d.drawString("The Wapens ", 585, 80);
        g2d.setColor(Color.BLACK.brighter().brighter());
        g2d.drawString("Score:", 620, 180);
        g2d.drawString("Hi-Score:", 620, 300);
        g2d.setFont(new Font("Verdana", Font.BOLD, 50));
        g2d.drawString("" + puntuacion, 620, 250);
        g2d.drawString("" + max, 620, 370);
    }

    void setPunto() {
        puntuacion++;
        if (max < puntuacion) {
            max = puntuacion;
        }
    }

    void reiniciar() {
        puntuacion = 0;
    }

}
