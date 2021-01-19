package com.practice.graph;

import java.awt.PrintGraphics;
import java.util.ArrayList;
import java.util.List;

public class GraphUsingAdjacencyList {

	public static void main(String[] args) {

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
		
		
	}

	private static void printAdjacencyList(List<List<Integer>> graph) {
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
