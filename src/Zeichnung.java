import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Zeichnung extends JPanel {
    private Vector<Figur> figuren;

    Zeichnung(Vector<Figur> f){
        this.figuren = f;
    }

    /**
     * Zeichnet alle Figuren.
     * @param g Referenz auf das Graphics-Objekt zum zeichnen.
     */
    public void zeichneFiguren(Graphics g) {

        for (Figur f : figuren){
            f.zeichne(g);
        }

        /*for (Figur f : figuren) {
            if (f instanceof Rechteck) {
                Rechteck r = (Rechteck)f;
                g.setColor(Color.BLUE);
                g.fillRect(r.getX(), r.getY(), r.getBreite(), r.getHoehe());
            } else if (f instanceof Kreis) {
                Kreis k = (Kreis)f;
                g.setColor(Color.BLUE);
                g.fillOval(k.getX(), k.getY(), k.getRadius(), k.getRadius());

            } else if (f instanceof Linie) {
                Linie l = (Linie)f;
                g.drawLine(l.getX(), l.getY(), l.getsPunkt(), l.getePunkt());
            }*/

            /* TODO: Hier muss für jede weitere Figur-Klasse, welche dargestellt werden können muss,
             * ein analoger Abschnitt, wie für die Rechteck-Klasse folgen.
             */


    }

    /**
     * Fügt eine weitere Figur hinzu und löst die Auffrischung des Fensterinhaltes aus.
     * @param figur Referenz auf das weitere Figur-Objekt.
     */
    public void hinzufuegen(Figur figur) {
        figuren.add(figur);
        repaint();
    }

    /**
     * Löscht alle Figuren und löst die Auffrischung des Fensterinhaltes aus.
     */
    public void allesLoeschen() {
        figuren.clear();
        repaint();
    }

}
