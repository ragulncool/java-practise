package com.ragul.demo.Graph;

import java.util.*;
class Graph

    //MAP< KEY , LIST>
    //KEY - EACH VERTICE
        // VALUE - LIST - ADJACENT VERTICES

{
    //stores the edges of the graph
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private boolean directed;

    public Graph(boolean directed) {
        this.directed= directed;
    }

    public void addNewVertex(Integer v) {
        adjList.putIfAbsent(v, new LinkedList<>());
    }

    //the method adds an edge between source and destination
    public void addNewEdge(Integer source, Integer destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
        if (!directed) {
            adjList.get(destination).add(source);
        }
    }

    // Remove an edge
    public void removeEdge(int src, int dest) {
        if (adjList.containsKey(src)) {
            adjList.get(src).remove(Integer.valueOf(dest));
        }
        if (!directed && adjList.containsKey(dest)) {
            adjList.get(dest).remove(Integer.valueOf(src));
        }
    }

    // Print the adjacency list
    public void printGraph() {
        System.out.println("Adjacency List:");
        for (int vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            System.out.println(adjList.get(vertex));
        }
    }

    public void countVertices() {
        System.out.println("Total number of vertices: " + adjList.keySet().size());
    }

    public void countEdges(boolean bidirection) {
        int count = 0;
        for (Integer v : adjList.keySet()) {
            count = count + adjList.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("Total number of edges: " + count);
    }

    public void containsVertex(Integer s) {
        if (adjList.containsKey(s)) {
            System.out.println("The graph contains " + s + " as a vertex.");
        } else {
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }


    //checks a graph has edge or not b/w source and dest
    public void containsEdge(Integer source, Integer dest) {
        if (adjList.get(source).contains(dest)) {
            System.out.println("The graph has an edge between " + source + " and " + dest + ".");
        } else {
            System.out.println("There is no edge between " + source + " and " + dest + ".");
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer v : adjList.keySet()) {
            builder.append(v.toString() + ": ");
            for (Integer w : adjList.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }

    public void BFS(Integer root) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> visited = new ArrayList<>(); //queue will have element cleared. so it maintain history wthether visited

        queue.add(root);
        visited.add(root);


        while (!queue.isEmpty()) {
            Integer currentNode = queue.remove();
            System.out.println("BFS Node:" + currentNode + " Queue:" + queue + " Visited:" + visited);

            for (Integer node : adjList.get(currentNode)) {
                if (!visited.contains(node)) {
                    queue.add(node);
                    visited.add(node);
                }
            }
        }
    }

    public void DFS(int root) {
        //same code as BFS except Stack is sued instead of Queue since stack will explore vertices unlike Queue which will visit
        Stack<Integer> stack = new Stack<>();
        List<Integer> visited = new ArrayList<>(); //stack will have element cleared. so it maintain history wthether visited

        stack.push(root);
        visited.add(root);


        while (!stack.isEmpty()) {
            Integer currentNode = stack.pop();
            System.out.println("DFS Node:" + currentNode + " Stack:" + stack + " Visited:" + visited);

            for (Integer node : adjList.get(currentNode)) {
                if (!visited.contains(node)) {
                    stack.push(node);
                    visited.add(node);
                }
            }
        }
    }

}

public class GraphImplementationUsingAdjList
{
    public static void main(String args[])
    {
        Graph graph=new Graph(false);

        graph.addNewEdge(0, 1);
        graph.addNewEdge(0, 4);
        graph.addNewEdge(1, 2);
        graph.addNewEdge(1, 3);
        graph.addNewEdge(1, 4);
        graph.addNewEdge(2, 3);
        graph.addNewEdge(2, 4);
        graph.addNewEdge(3, 0);
        graph.addNewEdge(2, 0);
        graph.addNewEdge(3, 5); //for BFS, 5 will be printed last. For DFS, 5 will printed after 3 (parent)
        graph.printGraph();


        System.out.println("Adjacency List for the graph:\n"+ graph.toString());
        graph.countVertices();
        graph.countEdges(true);
        graph.containsEdge(3, 4);
        graph.containsEdge(2, 4);
        graph.containsVertex(3);
        graph.containsVertex(5);

        graph.BFS(0);
        graph.DFS(0);
    }
}