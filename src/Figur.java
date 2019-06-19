import java.awt.*;

public abstract class Figur {
    protected int x, y;

    Figur(int x, int y){
        this.x = x;
        this.y = y;
    }

    Figur(){}

    public int getX() { return x; }

    public int getY() {
        return y;
    }
    public abstract void zeichne(Graphics g);
}
