package compulsoryPackage;

import java.awt.geom.Ellipse2D;

public class Circle extends Ellipse2D.Double {
    public Circle(int x0, int y0, int radius) {
        super(x0 - radius / 2, y0 - radius / 2, radius, radius);
    }
}
