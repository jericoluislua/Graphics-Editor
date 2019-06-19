import java.io.IOException;
import java.util.Vector;

public class Main {
    private static final Vector<Figur> figuren = new Vector<>();
    private static Vector<Linie> linien = new Vector<>();
    private static final Display display = new Display();
    private static final FigurSaver fsaver = new FigurSaver();
    private static Rechteck r = new Rechteck(100, 5,500,125);
    private static Linie l = new Linie(10, 120, 100, 1);
    private static Kreis k = new Kreis(610, 5, 250);
    private static RechteckRund rr = new RechteckRund(10, 150,200,125, 200, 300);
    private static Bogen b = new Bogen(50,300,100,100,900,100);
    private static Bogen b2 = new Bogen(50,500,100,100,900,100);


    public static void main(String[] args) {
        /*figuren.add(l);
        figuren.add(r);
        figuren.add(rr);
        figuren.add(k);
        figuren.add(b);
        figuren.add(b2);*/

        //not composite
        linien.add(new Linie(100, 50, 5, 5));
        linien.add(new Linie(70, 100, 5, 5));
        linien.add(new Linie(30, 100, 5, 5));
        int x[] = {linien.get(0).x,linien.get(1).x,linien.get(2).x};
        int y[] = {linien.get(0).y,linien.get(1).y,linien.get(2).y};
        Dreieck d = new Dreieck(5, 5, x, y);
        figuren.add(d);




        Zeichnung zeichnung = new Zeichnung(figuren);
        display.setZeichnung(zeichnung);


        try {
            fsaver.save(figuren);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
