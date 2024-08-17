package GraphAdjacent;

public class Edge {

    private Node node;
    private int distance;

    public Edge(Node node, int distance) {
        this.node= node;
        this.distance = distance;
    }

    public Node getNode() {
        return node;
    }
    public int getDistance() {
        return distance;
    }


}
