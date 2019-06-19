import java.awt.*;

public class GraphicsStub extends ConcreteGraphics{
    int nbOfDrawOvalCalls, x, y, radius;

    @Override
    public void drawOval(int x, int y, int width, int height) {
        nbOfDrawOvalCalls++;
        this.x = x;
        this.y = y;
        this.radius = width;
        this.radius = height;
    }

}
