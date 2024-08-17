package GraphAdjacent;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        /*graph.addNode('A',0);
        graph.addNode('B',0);
        graph.addNode('C',0);
        graph.addNode('D',0);
        graph.addNode('E',0);

        graph.addEdge('A','B');
        graph.addEdge('C','A');
        graph.addEdge('C','B');
        graph.addEdge('C','D');
        graph.addEdge('D','B');
        graph.addEdge('E','D');*/

        graph.addNode('S');
        graph.addNode('T');
        graph.addNode('X');
        graph.addNode('Y');
        graph.addNode('Z');

        graph.addEdge('S','T',10);
        graph.addEdge('S','Y',5);
        graph.addEdge('T','X',1);
        graph.addEdge('T','Y',2);
        graph.addEdge('X','Z',4);
        graph.addEdge('Y','T',3);
        graph.addEdge('Y','X',9);
        graph.addEdge('Y','Z',2);
        graph.addEdge('Z','S',7);
        graph.addEdge('Z','X',6);


        //graph.printList();
        graph.Dijkstras('S');
        graph.printList();


    }
}
