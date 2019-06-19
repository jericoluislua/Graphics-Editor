import java.awt.*;

public class RechteckRund extends Rechteck{
    private int bogenBreite, bogenHoehe;

    public RechteckRund(int x, int y, int breite, int hoehe, int bogenBreite, int bogenHoehe) {
        super(x, y, breite, hoehe);
        this.bogenBreite = bogenBreite;
        this.bogenHoehe = bogenHoehe;
    }
    public int getBogenBreite(){ return bogenBreite; }

    public int getBogenHoehe(){ return bogenHoehe; }

    @Override
    public void zeichne(Graphics g) { g.fillRoundRect(super.getX(),super.getY(),super.getBreite(), super.getHoehe(), getBogenBreite(), getBogenHoehe()); }
}
