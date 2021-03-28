package optionalPackage.shapes;

import java.awt.geom.Ellipse2D;

public class Circle extends Ellipse2D.Double {
    public int x;
    public int y;
    public int stroke;

    public Circle(int x0, int y0, int radius) {
        super(x0 - (radius / 2), y0 - (radius / 2), radius, radius);
        this.x = x0;
        this.y = y0;
        this.stroke = radius;
    }
}
