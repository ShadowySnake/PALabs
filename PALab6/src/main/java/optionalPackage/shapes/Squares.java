package optionalPackage.shapes;

import java.awt.geom.Rectangle2D;

public class Squares extends Rectangle2D.Double {
    public int x;
    public int y;
    public int width;

    public Squares(int x, int y, int width){
        super(x - width/2, y - width/2,width, width);
        this.x = x;
        this.y = y;
        this.width = width;
    }
}
