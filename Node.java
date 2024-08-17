package GraphAdjacent;
import java.util.*;

public class Node {

    private char data;
    private int maxDistance;
    private List<Node> adjacencyList;
    private List<Edge> edges;
    private Node predecessor;


    public Node(char data){
        this.data = data;
        this.adjacencyList = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public char getData() {
        return data;
    }
    public int getMaxDistance(){ return maxDistance;}
    public Node getPredecessor(){return predecessor;}

    public void setMaxDistance(int maxDistance){
        this.maxDistance = maxDistance;
    }
    public void setPredecessor(Node predecessor){this.predecessor = predecessor;}

    public List<Node> getAdjacencyList() {
        return adjacencyList;
    }
    public List<Edge> getEdges() {return edges;}

    public void printAdjacencyList(){
        for(int i = 0; i < adjacencyList.size(); i++){
            System.out.print(adjacencyList.get(i).getData() + "->");
        }
    }
}
