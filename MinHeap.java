package GraphAdjacent;

public class MinHeap {

    private int size;
    private int index;
    private Node[] heap;

    public MinHeap(int size){
        this.size = size;
        heap = new Node[size];
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }
    private int rightChild(int index) {return index * 2 + 2;}
    private int parent(int index){
        return (index - 1)/2;
    }
    private void heapify(int i){

        int left = leftChild(index);
        int right = rightChild(index);
        int root = i;
        if(left < index && heap[left].getMaxDistance() < heap[root].getMaxDistance()) root = left;
        if(right < index && heap[right].getMaxDistance() < heap[root].getMaxDistance()) root = right;

        if(root != i){
            Node temp = heap[root];
            heap[root] = heap[i];
            heap[i] = temp;
            heapify(root);
        }



    }
    private void heapifyAbove(int index){

        Node newNode = heap[index];

        while(index > 0 && newNode.getMaxDistance() < heap[parent(index)].getMaxDistance()){
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = newNode;

    }

    public Node findNode(Character data){

        for(int i = 0; i < index; i++){
            if(heap[i].getData() == data) return heap[i];
        }
        return null;
    }
    public int findIndexOfNode(Character data){
        for(int i = 0; i < heap.length; i++){
            if(heap[i].getData() == data) return i;
        }
        return -1;
    }
    public void add(Node node){

        if(index < size){
            heap[index] = node;
            heapifyAbove(index);
            index++;
        }
    }
    public Node extractMin(){

        Node node = heap[0];
        heap[0] = heap[index - 1];
        index--;
        heapify(0);

        return node;
    }
    public Node peek(){
        return heap[0];
    }
    public int getIndex() { return index;}
    public void printHeap(){

        for(int i = 0; i < index; i++){
            System.out.print(heap[i].getData() + ":" + heap[i].getMaxDistance() + " " );
        }
        System.out.println();

    }
    public boolean containsNode(Character data){

        for(int i = 0; i < index; i++){
            if(heap[i].getData() == data) return true;
        }
        return false;
    }
    public void updateValue(Node node, int distance, Node predecessor){
        int index = findIndexOfNode(node.getData());
        heap[index].setMaxDistance(distance);
        heap[index].setPredecessor(predecessor);
        heapifyAbove(index);
    }



}
