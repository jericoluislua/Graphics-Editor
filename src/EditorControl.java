import java.awt.*;
import java.util.Vector;

final class EditorControl {
  private Vector<Figur> figuren;////
  private Zeichnung zeichnung;
  private String figurTyp;
  private Point ersterPunkt;
  private int bogenHoehe, bogenBreite, startWinkel, bogenWinkel;
  //private Color color;

  public EditorControl(Vector<Figur> figuren){
    this.figuren = figuren;
    zeichnung = new Zeichnung(figuren);
  }



  public void allesNeuZeichnen(Graphics g) {
    zeichnung = new Zeichnung(figuren);
    //wenn ersterPunkt nicht lehr ist, soll es zeichnen
    if (ersterPunkt != null) {
      zeichnung.zeichneFiguren(g);
    }
  }

  public void setFigurTyp(String figurTyp) {
    this.figurTyp = figurTyp;
  }

  public void setErsterPunkt(Point ersterPunkt) {
    this.ersterPunkt = ersterPunkt;
  }

  public void setBogenHoehe(int bHoehe) { this.bogenHoehe = bHoehe; }

  public void setBogenBreite(int bBreite) {
    this.bogenBreite = bBreite;
  }

  public void setStartWinkel(int sWinkel) { this.startWinkel = sWinkel; }

  public void setBogenWinkel(int bWinkel) { this.bogenWinkel = bWinkel; }

  //public void setColor(Color color) { this.color = color;}

  public void erzeugeFigurMitZweitemPunkt(Point zweiterPunkt) {

    // ↑
    // y < x >
    // ↓
    int breite = zweiterPunkt.x - ersterPunkt.x;
    int hoehe = zweiterPunkt.y - ersterPunkt.y;
    if(figurTyp == "R") {
      //min chooses the smaller value between the two variables
      //abs always returns positive value if value is negative
      zeichnung.hinzufuegen(new Rechteck(Math.min((int)ersterPunkt.getX(), (int)zweiterPunkt.getX()), Math.min((int)ersterPunkt.getY(), (int)zweiterPunkt.getY()), Math.abs(breite), Math.abs(hoehe)));
      System.out.println("Width: " + breite);
      System.out.println("Height: " + hoehe);
    }

    //getX & getY are double
    //x & y are int
    if(figurTyp == "C"){
      //takes the distance between the two coordinates Point.distance is double
      int radius = (int)Point.distance(ersterPunkt.getX(), ersterPunkt.getY(), zweiterPunkt.getX(),zweiterPunkt.getY());
      zeichnung.hinzufuegen(new Kreis(Math.min((int)ersterPunkt.getX(), (int)zweiterPunkt.getX()), Math.min((int)ersterPunkt.getY(), (int)zweiterPunkt.getY()), radius));//Math.abs(breite)));
    }
    if(figurTyp == "L"){
      zeichnung.hinzufuegen(new Linie((int)ersterPunkt.getX(), (int)ersterPunkt.getY(), (int)zweiterPunkt.getX(),(int)zweiterPunkt.getY()));
    }
    if(figurTyp == "RR"){

      zeichnung.hinzufuegen(new RechteckRund(Math.min((int)ersterPunkt.getX(), (int)zweiterPunkt.getX()), Math.min((int)ersterPunkt.getY(), (int)zweiterPunkt.getY()), Math.abs(breite), Math.abs(hoehe), bogenBreite, bogenHoehe));
    }
    if(figurTyp == "A"){
      zeichnung.hinzufuegen(new Bogen((int)ersterPunkt.getX(), (int)ersterPunkt.getY(), breite, hoehe, startWinkel, bogenWinkel));
    }
    if(figurTyp == "DEL"){
      zeichnung.allesLoeschen();
    }
  }
}
