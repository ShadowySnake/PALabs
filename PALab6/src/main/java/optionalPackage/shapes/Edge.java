package optionalPackage.shapes;

public class Edge {
    Circle from;
    Circle to;
    int stroke;

    public Edge(Circle from, Circle to, int stroke) {
        this.from = from;
        this.to = to;
        this.stroke = stroke;
    }

    public Circle getFrom() {
        return from;
    }

    public Circle getTo() {
        return to;
    }

    public int getStroke() {
        return stroke;
    }
}
