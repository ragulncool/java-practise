package com.ragul.demo.Graph;

public class GraphImplementation2 {

    public static void main(String args[]){
        Graph2 graph=new Graph2(5);

        //add edges to the graph
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.removeEdge(3, 4);

        graph.printAdjacencyMatrix();
    }
}
class Graph2 {

    //stores the number of vertices
    private int vertices;

    //creates a 2d boolean array for the adjacency list of the graph
    private boolean adjlist[][];

    //creating a constructor of the Graph class
    Graph2(int vertices) {
        //assigning the number of vertices to the passed parameter
        this.vertices = vertices;
        this.adjlist = new boolean[vertices][vertices];

        System.out.println("INITIAL ADJACENCY MATRIX");
        printAdjacencyMatrix();
    }

    void addEdge(int src, int des) {
        adjlist[src][des]=true;
    }

    void removeEdge(int src, int des) {
        adjlist[src][des]=false;
    }

    public void printAdjacencyMatrix() {
        System.out.println(" ADJACENCY MATRIX");


        for (int i=0; i<adjlist.length; ++i){
            for (int j=0; j<adjlist.length; ++j){
                int output = adjlist[i][j]?1:0;
                System.out.print(output+" ");
            }
            System.out.println();
        }

    }
}