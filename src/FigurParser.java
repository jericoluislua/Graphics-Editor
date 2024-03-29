import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FigurParser {
  //private FigurFileDAO dao;
  private FigurDAO dao;

  //Data Access Object
  public FigurParser(FigurDAO dao) {
    this.dao = dao;
  }

  //public List<Figur> parse() {
  public Vector<Figur> parse() {
    //List<Figur> figuren = new ArrayList<Figur>();
    Vector<Figur> figuren = new Vector<Figur>();
    String[] figurData = dao.readNextFigurData();
    while (figurData != null) {
      String figurTyp = figurData[0];
      int x = Integer.valueOf(figurData[1]);
      int y = Integer.valueOf(figurData[2]);
      switch (figurTyp) {
      case "Rechteck":
        int breite = Integer.valueOf(figurData[3]);
        int hoehe = Integer.valueOf(figurData[4]);
        figuren.add(new Rechteck(x, y, breite, hoehe));
        break;
      case "Kreis":
        int radius = Integer.valueOf(figurData[3]);
        figuren.add(new Kreis(x, y, radius));
        break;
      case "Linie":
        int endx = Integer.valueOf(figurData[3]);
        int endy = Integer.valueOf(figurData[4]);
        figuren.add(new Linie(x, y, endx, endy));
        break;
      }
      figurData = dao.readNextFigurData();
    }
    return figuren;
  }
}
