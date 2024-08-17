package GraphAdjacent;

import java.util.*;

public class Graph {

    private List<Node> nodes;

    public Graph(){
        this.nodes = new ArrayList<>();
    }

    //helper methods
    public void printList(){
        for(Node e : nodes){
            System.out.println(e.getData() + " " + e.getMaxDistance());
        }
    }
    private void printList(List<Node>list){
        for(Node e : list){
            System.out.print(e.getData() + "->");
        }
    }
    private void printQueue(Queue<Node>queue){

        for(Node e : queue){
            System.out.print(e.getData() + " ");
        }

    }

    private Node findNode(char data){
        for(Node e : nodes){
            if(e.getData() == data) return e;
        }
        return null;
    }
    private Edge findEdge(Node node1, char nodeName2){

        for(Edge e : node1.getEdges()){
            if(e.getNode().getData() == nodeName2) return e;
        }
        return null;
    }

    public boolean addNode(char data){
        if(findNode(data) != null) return false;
        nodes.add(new Node(data));
        return true;
    }
    public boolean addEdge(char node1, char node2, int weight){

        Node node = findNode(node1);
        Node otherNode = findNode(node2);

        if(node == null || otherNode == null) return false;
        node.getAdjacencyList().add(otherNode);
        node.getEdges().add(new Edge(otherNode,weight));

        return true;
    }
    public List<Node> breadthFirstSearch(char node){

        List<Node> list = new ArrayList<>();
        Queue<Node>queue = new LinkedList<>();

        Node src = findNode(node);
        queue.add(src);



        while(!queue.isEmpty()){

            List<Node> temp = src.getAdjacencyList();
            int size = src.getAdjacencyList().size();

            if(!list.contains(queue.peek())) list.add(queue.peek());

            queue.poll();
            for(int i = 0; i < size; i++){
                if(!list.contains(temp.get(i))) {
                    queue.add(temp.get(i));

                }
            }
            src = queue.peek();
        }
        return list;
    }
    public List<Node> depthFirstSearch(Character data){

        Node src = findNode(data);
        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(src);
        list.add(stack.peek());

        while(!stack.isEmpty()){

            List<Node>temp = src.getAdjacencyList();
            int size = temp.size();

            stack.pop();

            for(int i = 0; i < size; i++){
                if(!list.contains(temp.get(i))){
                    stack.push(temp.get(i));
                    list.add(stack.peek());
                }
            }
            if(!stack.isEmpty())src = stack.peek();
        }
        return list;
    }



    public void Dijkstras(Character data){

        List<Node>visited = new ArrayList<>();

        Node src = findNode(data);
        src.setMaxDistance(0);

        for(Node e : nodes) {
            if(e != src) e.setMaxDistance(Integer.MAX_VALUE);
            e.setPredecessor(null);
        }

       MinHeap heap = new MinHeap(nodes.size());
       heap.add(src);

       while(heap.getIndex() > 0){

           List<Node> adjacentNodes = src.getAdjacencyList();
           visited.add(src);
           heap.extractMin();


           for(int i = 0; i < adjacentNodes.size(); i++){

               Node adjacent = adjacentNodes.get(i);

               Edge edge = findEdge(src, adjacent.getData());
               if(!visited.contains(adjacent)) heap.add(adjacent);

               if(src.getMaxDistance() + edge.getDistance() < adjacent.getMaxDistance()){
                   int distance = src.getMaxDistance() + edge.getDistance();
                   adjacent.setMaxDistance(distance);
                   adjacent.setPredecessor(src);
                   heap.updateValue(adjacent,distance,src);
               }
           }
           src = heap.peek();
       }

       for(Node e : nodes){

           Node parent = e;
           System.out.print(e.getData() + ": ");
           String path = "";

           while(parent != null){
               path += parent.getData() + " >- ";
               parent = parent.getPredecessor();
           }
           StringBuilder input1 = new StringBuilder();
           input1.append(path);
           input1.reverse();
           System.out.print(input1 + "\n");
       }


    }








}
