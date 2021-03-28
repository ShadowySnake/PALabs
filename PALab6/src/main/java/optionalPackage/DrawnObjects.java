package optionalPackage;

import optionalPackage.shapes.Circle;
import optionalPackage.shapes.Edge;
import optionalPackage.shapes.SimpleLines;
import optionalPackage.shapes.Squares;

import java.util.ArrayList;
import java.util.List;

public class DrawnObjects {
    List<Circle> nodesList;
    List<Edge> edgesList;
    List<Squares> squaresList;
    List<SimpleLines> linesList;

    public DrawnObjects() {
        this.nodesList = new ArrayList<>();
        this.edgesList = new ArrayList<>();
        this.squaresList = new ArrayList<>();
        this.linesList = new ArrayList<>();
    }

    public void addNode(int x, int y, int stroke) {
        this.nodesList.add(new Circle(x, y, stroke));
    }

    public void addEdge(Circle from, Circle to, int stroke) {
        this.edgesList.add(new Edge(from, to, stroke));
    }

    public void addSquare(Squares square){
        this.squaresList.add(square);
    }

    public void addLine(SimpleLines line){
        this.linesList.add(line);
    }

    public Circle getNodeAt(int x, int y) {
        for (Circle node: nodesList) {
            double distSq = Math.pow(node.x - x, 2) + Math.pow(node.y - y, 2);

            if (distSq <= Math.pow(node.stroke, 2)) {
                return node;
            }
        }

        return null;
    }

    public Squares getSquareAt(int x, int y){
        for (Squares square : squaresList){
            double distSq = Math.pow((square.x - x),2) + Math.pow(square.y - y, 2);

            if(distSq <= Math.pow(square.width,2)){
                return square;
            }
        }
        return null;
    }

    public SimpleLines getLineAt(int x,int y, int stroke){
        for (SimpleLines line: linesList){
            double distSqStart = Math.pow((line.startX - x),2) + Math.pow(line.startY - y, 2);
            double distSqEnd = Math.pow((line.endX - x),2) + Math.pow(line.endY - y, 2);

            if( (distSqStart <= Math.pow(stroke,2)) || (distSqEnd <= Math.pow(stroke,2)) ){
                return line;
            }
        }
        return null;
    }

    public List<Circle> getNodes() {
        return nodesList;
    }

    public List<Edge> getEdges() {
        return edgesList;
    }

    public List<Squares> getSquaresList(){
        return squaresList;
    }

    public List<SimpleLines> getLinesList(){
        return linesList;
    }

    public void deleteNode(Circle node) {
        this.nodesList.remove(node);

        List<Edge> edgesToRemove = new ArrayList<>();

        for (Edge edge: edgesList) {
            if(edge.getTo() == node || edge.getFrom() == node) {
                edgesToRemove.add(edge);
            }
        }

        edgesList.removeAll(edgesToRemove);
    }

    public void deleteSquare(Squares square){
        this.squaresList.remove(square);
    }

    public void deleteLine(SimpleLines line){
        this.linesList.remove(line);
    }

    @Override
    public String toString(){
        StringBuilder shapesRecognizer = new StringBuilder("The following shapes have been found:\n");

        for (Circle circles : nodesList){
            shapesRecognizer.append("Node found at ").append(circles.x).append(",").append(circles.y).append("\n");
        }

        for (Edge edge : edgesList){
            shapesRecognizer.append("Line found between nodes ").append(edge.getTo().x).append(",")
                    .append(edge.getTo().y).append(" and ").append(edge.getFrom().x).append(",")
                    .append(edge.getFrom().y).append("\n");
        }

        for (Squares square : squaresList){
            shapesRecognizer.append("Square found at ").append(square.x).append(",").append(square.y).append("\n");
        }
        return shapesRecognizer.toString();
    }
}
