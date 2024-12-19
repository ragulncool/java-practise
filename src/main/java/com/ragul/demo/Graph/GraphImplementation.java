package com.ragul.demo.Graph;

import java.util.*;
class Graph

    //MAP< KEY , LIST>
    //KEY - EACH VERTICE
        // VALUE - LIST - ADJACENT VERTICES

{
    //stores the edges of the graph
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public void addNewVertex(Integer s) {
        map.put(s, new LinkedList<Integer>());
    }

    //the method adds an edge between source and destination
    public void addNewEdge(Integer source, Integer destination, boolean bidirectional) {
        if (!map.containsKey(source))
            addNewVertex(source);
        if (!map.containsKey(destination))
            addNewVertex(destination);
        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

    public void countVertices() {
        System.out.println("Total number of vertices: " + map.keySet().size());
    }

    public void countEdges(boolean bidirection) {
        int count = 0;
        for (Integer v : map.keySet()) {
            count = count + map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("Total number of edges: " + count);
    }

    public void containsVertex(Integer s) {
        if (map.containsKey(s)) {
            System.out.println("The graph contains " + s + " as a vertex.");
        } else {
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }


    //checks a graph has edge or not b/w source and dest
    public void containsEdge(Integer source, Integer dest) {
        if (map.get(source).contains(dest)) {
            System.out.println("The graph has an edge between " + source + " and " + dest + ".");
        } else {
            System.out.println("There is no edge between " + source + " and " + dest + ".");
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (Integer w : map.get(v)) {
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

            for (Integer node : map.get(currentNode)) {
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

            for (Integer node : map.get(currentNode)) {
                if (!visited.contains(node)) {
                    stack.push(node);
                    visited.add(node);
                }
            }
        }
    }
}

public class GraphImplementation
{
    public static void main(String args[])
    {
        Graph graph=new Graph();

        graph.addNewEdge(0, 1, true);
        graph.addNewEdge(0, 4, true);
        graph.addNewEdge(1, 2, true);
        graph.addNewEdge(1, 3, false);
        graph.addNewEdge(1, 4, true);
        graph.addNewEdge(2, 3, true);
        graph.addNewEdge(2, 4, true);
        graph.addNewEdge(3, 0, true);
        graph.addNewEdge(2, 0, true);
        graph.addNewEdge(3, 5, true); //for BFS, 5 will be printed last. For DFS, 5 will printed after 3 (parent)


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