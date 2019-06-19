import java.io.IOException;
import java.util.Vector;

public final class Grafikeditor {


  public static void main(String[] args) {
    FigurFileDAO dao = new FigurFileDAO();
    FigurParser fp = new FigurParser(dao);
    Vector<Figur> figuren = fp.parse();
    dao.close();
    new Grafikeditor(figuren);

  }

  private Grafikeditor(Vector<Figur> figuren) {
    @SuppressWarnings("unused")
    EditorFrame frame = new EditorFrame(800, 600, figuren);
  }
}
