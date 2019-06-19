import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
//eventquelle
final class EditorPanel extends JPanel {
  private EditorControl editorControl;

  EditorPanel(EditorControl eControl) {
    this.editorControl = eControl;
    //parameter is the anonymous class which implements mouseListener in this case new MouseAdapter
    //MouseAdapter(Klasse) implements MouseListener(interface)
    addMouseListener(new MouseAdapter() {
      //anonyme Klasse, abgeleitet von MouseAdapter
      @Override
      public void mousePressed(MouseEvent mEvent) {
        System.out.println("Mouse pressed at: " + mEvent.getPoint());
        editorControl.setErsterPunkt(mEvent.getPoint());
      }

      @Override
      public void mouseReleased(MouseEvent mEvent) {
        System.out.println("Mouse released at: " + mEvent.getPoint());
        editorControl.erzeugeFigurMitZweitemPunkt(mEvent.getPoint());
        repaint();
      }
    });
  }

  // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
  // Methode beim EditorFrame oder beim EditorPanel aufruft.
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    editorControl.allesNeuZeichnen(g);
  }
}
//Ereignisquelle = MouseListener = interface
//Ereignisempfänger EditorPanel