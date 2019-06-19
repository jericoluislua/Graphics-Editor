import java.awt.*;

public class Rechteck extends Figur{
    private int breite, hoehe;

    public Rechteck(int x, int y, int breite, int hoehe) {
        super(x, y);
        this.breite = breite;
        this.hoehe = hoehe;
    }

    Rechteck(){}

    public int getBreite() {
        return breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    @Override
    public void zeichne(Graphics g) {  g.drawRect(getX(), getY(), getBreite(), getHoehe()); }
}
