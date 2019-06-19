import java.awt.*;

public class Linie extends Figur{
    private int sPunkt, ePunkt;

    public Linie(int x, int y, int sPunkt, int ePunkt) {
        super(x, y);
        this.sPunkt = sPunkt;
        this.ePunkt = ePunkt;
    }

    public int getsPunkt() {
        return sPunkt;
    }

    public int getePunkt() { return ePunkt; }

    @Override
    public void zeichne(Graphics g) {
        g.drawLine(getX(), getY(), getsPunkt(), getePunkt());
    }
}
