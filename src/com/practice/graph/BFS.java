package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFS {

	public static void main(String[] args) {
		/** 
		 *   
		 *   0 --- 1 ---- 3
		 *   |   /
		 *   |  /
		 *    2
		 *       
		 */    
		List<List<Integer>> adjListGraph = createGraph(); // This method creates above graph.
		
		performBFS(adjListGraph, 4, 0);
		

	}

	private static void performBFS(List<List<Integer>> adjListGraph, int vertices, int source) {
		
		Queue<Integer> stage = new LinkedList<Integer>();
		
		boolean[] hasVisited = new boolean[vertices];
		hasVisited[source] = true;
		
		stage.add(source);
		
		System.out.println("*** BFS ***");
		
		while (!stage.isEmpty()) {
			int vertex = stage.poll();
			System.out.print(vertex+" ");
			
			for (Integer connectedVertex : adjListGraph.get(vertex)) {
				
				if(!hasVisited[connectedVertex]) {
					hasVisited[connectedVertex] = true;
					stage.add(connectedVertex);
				}
			}
			
			
			
		}
		
		
	}

	public static List<List<Integer>> createGraph() {

		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		int vertexCount = 5;
		
		for (int i = 0; i < vertexCount; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		/** 
		 *   
		 *   0 --- 1 ---- 3
		 *   |   /
		 *   |  /
		 *    2    
		 *    
		 *   Representing above graph in for of adjacency list.
		 */
		
		addEdge(graph, 0,1);
		addEdge(graph, 0,2);
		addEdge(graph, 1,2);
		addEdge(graph, 1,3);
		
		printAdjacencyList(graph);
		
		return graph;
		
	}

	private static void printAdjacencyList(List<List<Integer>> graph) {
		System.out.println("*** Adjacency List representation ***");
		for (List<Integer> list : graph) {
			for (Integer vertex : list) {
				System.out.print(vertex+ "  ");
			}
			System.out.println();
		}
		
	}

	private static void addEdge(List<List<Integer>> graph, int i, int j) {
		/*
		 * Since its a undirected graph we ar adding from both side.
		 */
		graph.get(i).add(j);
		graph.get(j).add(i);
		
	}
}
