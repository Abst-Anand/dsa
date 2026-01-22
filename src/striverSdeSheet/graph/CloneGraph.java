package src.striverSdeSheet.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Node{
	int val;
	ArrayList<Node> neighbors;
	
	Node(){
		val = 0;
		neighbors = new ArrayList<Node>();
	}
	
	Node(int _val){
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	
	Node(int _val, ArrayList<Node> _neighbors){
		val = _val;
		neighbors = _neighbors;
	}
	
}
public class CloneGraph {
	
	static Node dfs(Node node, Map<Integer,Node> map){
		if(map.containsKey(node.val)) return map.get(node.val);
		Node copy = new Node(node.val);
		map.put(copy.val, copy);
		
		for(Node neighbor : node.neighbors) {
			copy.neighbors.add(dfs(neighbor,map));
		}
		return copy;
	}
	
	static Node cloneGraph(Node node){
		Map<Integer, Node> map = new HashMap<>();
		Node ans =  dfs(node, map);
		System.out.println(ans);
		System.out.println(map.get(1));
		return ans;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		node1.neighbors.add(node2);
		node1.neighbors.add(node3);
		
		node2.neighbors.add(node1);
		node2.neighbors.add(node4);

		node3.neighbors.add(node1);
		node3.neighbors.add(node4);
		
		node4.neighbors.add(node2);
		node4.neighbors.add(node3);
		
		System.out.println(node1 +", " + node2 +", " + node3 +", " + node4);
		cloneGraph(node1);
	}

}
