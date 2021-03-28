package optionalPackage;

import optionalPackage.shapes.Circle;
import optionalPackage.shapes.Edge;
import optionalPackage.shapes.Squares;

import java.util.ArrayList;
import java.util.List;

public class DrawnObjects {
    List<Circle> nodesList;
    List<Edge> edgesList;
    List<Squares> squaresList;

    public DrawnObjects() {
        this.nodesList = new ArrayList<>();
        this.edgesList = new ArrayList<>();
        this.squaresList = new ArrayList<>();
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

    public List<Circle> getNodes() {
        return nodesList;
    }

    public List<Edge> getEdges() {
        return edgesList;
    }

    public List<Squares> getSquaresList(){
        return squaresList;
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
}
