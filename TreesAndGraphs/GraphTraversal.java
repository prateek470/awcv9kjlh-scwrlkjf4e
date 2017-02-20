package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * CTCI Problem 4.2
 * @author prateek
 *
 */
//State of a Node
enum State{
	UnDiscovered,Discovered,Finished
}
//create Node
class Node{
	String name;
	List<Edge> connections;
	State state;
	Node(String name, List<Edge> conn){
		this.name = name;
		this.connections = conn;
	}
	List<Node> getAdjacent(){
		List<Node> result = new ArrayList<>();
		for(Edge e:this.connections){
			if(e.start == this){
				result.add(e.end);
			}
		}
		return result;
	}
}
//Create edges
class Edge{
	Node start;
	Node end;
	double weight;
	Edge(Node Start, Node end, double weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
//Create a graph
class Graph{
	List<Node> nodes;
	Graph(){
		this.nodes = new ArrayList<>();
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
}

public class GraphTraversal {
	//Depth First Search
	static boolean isPathExist(Graph g, Node start, Node end){
		LinkedList<Node> stack = new LinkedList<>();
		for(Node u:g.getNodes()){
			u.state = State.UnDiscovered;
		}
		start.state = State.Discovered;
		stack.add(start);
		while(!stack.isEmpty()){
			Node temp = stack.removeFirst();
			if(temp!=null){
				for(Node v : temp.getAdjacent()){
					if(v.state == State.UnDiscovered){
						if(v == end){
							return true;
						}else{
							v.state = State.Discovered;
							stack.add(v);
						}
					}
				}
				temp.state = State.Finished;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Graph g = new Graph();
		
	}
}
