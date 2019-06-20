import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Vector;

import static junit.framework.TestCase.assertEquals;

public class KreisTest {
    //graphics abstract
    private GraphicsStub g = new GraphicsStub();

    @Test
    public void testZeichne(){
        Kreis k = new Kreis(610, 5, 250);
        k.zeichne(g);
        assertEquals(1, g.nbOfDrawOvalCalls);
        assertEquals(610, g.x);
        assertEquals(5, g.y);
        assertEquals(250, g.radius);
    }
}
