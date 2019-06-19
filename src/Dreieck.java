import java.awt.*;
import java.util.Vector;

public class Dreieck extends Figur{
    /* composite
    private static Vector<Linie> linien = new Vector<>();*/
    int x[], y[];

    public Dreieck(int superx, int supery, int x[], int y[]){
        super(superx, supery);
        this.x = x;
        this.y = y;
        /*for(int i = 0; i > 3; i++){
            linien.get(i).x = x[i];
            linien.get(i).y = y[i];
        }*/
    }
    @Override
    public void zeichne(Graphics g) {
        g.drawPolygon(x, y, 3);
        /*
        for(Linie l:linien) {
            l.zeichne(g);
        }*/
    }
}
