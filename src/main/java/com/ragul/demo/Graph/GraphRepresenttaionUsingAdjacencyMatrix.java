package com.ragul.demo.Graph;

public class GraphRepresenttaionUsingAdjacencyMatrix {

    public static void main(String args[]){
        Graph3 graph=new Graph3(5);

        //add edges to the graph
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.removeEdge(3, 4);

        graph.printAdjacencyMatrix();
    }
}
class Graph3 {

    //stores the number of vertices
    private int vertices;

    //creates a 2d boolean array for the adjacency list of the graph
    private boolean adjMatrix[][];

    //creating a constructor of the Graph class
    Graph3(int vertices) {
        //assigning the number of vertices to the passed parameter
        this.vertices = vertices;
        this.adjMatrix = new boolean[vertices][vertices];

        System.out.println("INITIAL ADJACENCY MATRIX");
        printAdjacencyMatrix();
    }


    void addEdge(int src, int des) {
        if (src >= 0 && src < vertices && des >= 0 && des < vertices)
            adjMatrix[src][des]=true;
        else
            System.out.println("Invalid vertices.");
//        if (!directed) {
//            adjMatrix[dest][src] = 1;
//        }
    }

    void removeEdge(int src, int des) {
        if (src >= 0 && src < vertices && des >= 0 && des < vertices)
            adjMatrix[src][des]=false;
        else
            System.out.println("Invalid vertices.");
    }

    public boolean hasEdge(int src, int des) {
        if (src >= 0 && src < vertices && des >= 0 && des < vertices)
            return adjMatrix[src][des]; //true
        return false;
    }


    public void printAdjacencyMatrix() {
        System.out.println(" ADJACENCY MATRIX");


        for (int i = 0; i< adjMatrix.length; ++i){
            for (int j = 0; j< adjMatrix.length; ++j){
                int output = adjMatrix[i][j]?1:0;
                System.out.print(output+" ");
            }
            System.out.println();
        }

    }
}