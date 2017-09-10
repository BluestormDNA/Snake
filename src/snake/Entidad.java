package snake;

public class Entidad implements Constantes{

    protected int x;
    protected int y;

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
    
    public void setPosicion(int x, int y){
        setX(x);
        setY(y);
    }
}