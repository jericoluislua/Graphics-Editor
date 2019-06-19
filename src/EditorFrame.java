import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
final class EditorFrame extends JFrame {
  private Vector<Figur> figuren=null;
  private EditorControl editorControl;
  private Set<Character> pressedKeys = new HashSet<>();
  public int bogenBreite, bogenHoehe, startWinkel, bogenWinkel;


  public EditorFrame(int breite, int hoehe, Vector<Figur> figuren) {
    this.figuren = figuren;
    editorControl = new EditorControl(figuren);
    erzeugeUndSetzeEditorPanel();
    fensterEinmitten(breite, hoehe);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent kEvent) {
        pressedKeys.add(kEvent.getKeyChar());


        //https://stackoverflow.com/questions/2623995/swings-keylistener-and-multiple-keys-pressed-at-the-same-time
        if(pressedKeys.size() == 2){
          if(pressedKeys.contains('r') && pressedKeys.contains('c')) {
            System.out.println("Keys Pressed: R + C(for Rounded Rectangle)");
            editorControl.setFigurTyp("RR");
          }
        }
        else{
          if(kEvent.getKeyCode() == KeyEvent.VK_R) {
            System.out.println("Key Pressed: R(for Rectangle)");
            editorControl.setFigurTyp("R");
          }
          if(kEvent.getKeyCode() == KeyEvent.VK_C) {
            System.out.println("Key Pressed: C(for Circle)");
            editorControl.setFigurTyp("C");
          }
          if(kEvent.getKeyCode() == KeyEvent.VK_L) {
            System.out.println("Key Pressed: L(for Line)");
            editorControl.setFigurTyp("L");
          }
          if(kEvent.getKeyCode() == KeyEvent.VK_T) {
            System.out.println("Key Pressed: T(for Triangle)");
            editorControl.setFigurTyp("T");
          }
          if(kEvent.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("Key Pressed: A(for Arc)");
            editorControl.setFigurTyp("A");
          }
        }
        if(kEvent.getKeyCode() == KeyEvent.VK_DELETE){
          System.out.println("Key Pressed: D(for Deletion)");
          editorControl.setFigurTyp("DEL");
        }
      }

      @Override
      public void keyReleased(KeyEvent kEvent) {
        Scanner sc = new Scanner(System.in);
        if(pressedKeys.size() == 2){
          if(pressedKeys.contains('r') && pressedKeys.contains('c')) {
            System.out.print("Bogenbreite: ");
            bogenBreite =  sc.nextInt();
            editorControl.setBogenBreite(bogenBreite);
            System.out.print("Bogenhoehe: ");
            bogenHoehe = sc.nextInt();
            editorControl.setBogenHoehe(bogenHoehe);
          }
        }else{
          if(pressedKeys.contains('a')){
            System.out.print("Startwinkel: ");
            startWinkel = sc.nextInt();
            editorControl.setStartWinkel(startWinkel);
            System.out.print("Bogenwinkel: ");
            bogenWinkel = sc.nextInt();
            editorControl.setBogenWinkel(bogenWinkel);
          }
        }
        pressedKeys.remove(kEvent.getKeyChar());
      }
    });
  }

  private void erzeugeUndSetzeEditorPanel() {
    JPanel panel = new EditorPanel(editorControl);
    setContentPane(panel);
  }

  private void fensterEinmitten(int breite, int hoehe) {
    Dimension bildschirmGroesse = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle fensterAusschnitt = new Rectangle();
    fensterAusschnitt.width = breite;
    fensterAusschnitt.height = hoehe;
    fensterAusschnitt.x = (bildschirmGroesse.width - fensterAusschnitt.width) / 2;
    fensterAusschnitt.y = (bildschirmGroesse.height - fensterAusschnitt.height) / 2;
    setBounds(fensterAusschnitt);
  }
}
