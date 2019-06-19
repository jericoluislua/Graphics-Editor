import java.awt.*;

public class Kreis extends Figur{
    private int radius;

    public Kreis(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public int getRadius() { return radius; }

    @Override
    public void zeichne(Graphics g) { g.fillOval(getX(), getY(), getRadius(), getRadius()); }
        //g.setColor(Color.BLUE);


    @Override
    public String toString() {
        return "Kreis, " + x + ", " + y + ", " + radius + ", " + radius;
    }
}
