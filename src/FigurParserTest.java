import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static junit.framework.TestCase.assertEquals;

public class FigurParserTest {
    private FigurDAO dao;
    private FigurParser fp;

    @Before
    public void setup(){
        dao = new FigurDAOStub();
        fp = new FigurParser(dao);
    }

    @Test
    public void test(){
        Vector<Figur> figuren = fp.parse();
        assertEquals(3, figuren.size());
        assertEquals(new Rechteck(100, 5, 500, 125), figuren.get(0).toString());
        //assertEquals("Linie, 10, 120, 100, 1", figuren.get(1).toString());
        //assertEquals("Kreis, 610, 5, 250", figuren.get(2).toString());
    }
}
