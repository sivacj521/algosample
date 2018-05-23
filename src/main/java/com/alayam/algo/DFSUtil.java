package com.alayam.algo;

// Java program to print DFS traversal from a given given graph

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

// This class represents a directed graph using adjacency list
// representation
class Graph
{
    private int V;                      // No. of vertices
    private LinkedList<Integer> adj[];  // Adjacency List

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v,boolean visited[])
    {
        visited[v] = true; // Mark the current node as visited and print it
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }


    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    //prints BFS traversal from a given source s
    boolean isReachable(int s, int d) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s]=true;
        queue.add(s);

        while (queue.size()!=0) {
            s = queue.poll();

            ListIterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                {
                    int n = i.next();
                    if (n == d) {
                        return true;
                    }

                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }

        // If BFS is complete without visited d
        return false;
    }

    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);


        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
