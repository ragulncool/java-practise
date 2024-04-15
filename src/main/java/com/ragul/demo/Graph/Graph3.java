package com.ragul.demo.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Graph3 {


    //stores the number of vertices
    private int Vertices;

    //creates a linked list for the adjacency list of the graph
    private LinkedList<Integer> adjlist[];

    //creating a constructor of the Graph class
    Graph3(int count_v) {
        //assigning the number of vertices to the passed parameter
        Vertices = count_v;
        adjlist = new LinkedList[count_v];   //array(vertices, list of adjacent)

        //loop for creating the adjacency lists
        for (int i=0; i<count_v; ++i){
            adjlist[i] = new LinkedList();
         }
    }

    void addNewEdge(int v, int w) {
        adjlist[v].add(w);  // Add w to v's list.
    }

    public void printAllVertices() {

            for (int i=0; i<adjlist.length; ++i){

            }

    }
}