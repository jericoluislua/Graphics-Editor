import org.junit.Test;

import java.awt.*;
import java.util.Vector;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ZeichnungTestMitMock {

    private Graphics g = mock(Graphics.class);

    @Test
    public void zeichneFiguren() {
        Vector<Figur> figuren = new Vector<>();
        Rechteck r = new Rechteck(100, 5, 500, 125);
        Kreis k = new Kreis(610, 5, 250);
        Linie l = new Linie(10, 120, 100, 1);
        figuren.add(r);
        figuren.add(k);
        figuren.add(l);
        for (Figur f : figuren){
            f.zeichne(g);
        }

        verify(g).drawLine(10, 120, 100, 1);
        verify(g).fillOval(610, 5, 250, 250);
        verify(g).drawRect(100, 5, 500, 125);
    }
}