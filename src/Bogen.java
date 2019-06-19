import java.awt.*;

public class Bogen extends Rechteck{
    private int startWinkel, bogenWinkel;

    public Bogen(int x, int y, int breite, int hoehe, int startWinkel, int bogenWinkel){
        super(x, y, breite, hoehe);
        this.startWinkel = startWinkel;
        this.bogenWinkel = bogenWinkel;
    }

    public int getStartWinkel() { return startWinkel; }

    public int getBogenWinkel() { return bogenWinkel; }

    @Override
    public void zeichne(Graphics g) { g.fillArc(getX(), getY(), getBreite(), getHoehe(), getStartWinkel(), getBogenWinkel());}
}
