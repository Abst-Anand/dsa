package src.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import src.tree.Node;

public class LevelOrder {
	
	public static void levelOrder(Node<Integer> root) {
		
		Queue<Node<Integer>> q = new LinkedList<>();
		q.add(root);
		
		ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int numOfNodesPerLevel = q.size();
			ArrayList<Integer> subList = new ArrayList<>();
			
			for(int i=0; i<numOfNodesPerLevel; i++) {
				Node<Integer> curr = q.poll();
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
				subList.add(curr.data);
			}
			
			levels.add(subList);	
		}
		System.out.println(levels.size());
		System.out.println(levels);
	}
	
	public static void main(String[] args) {
		
		Node<Integer> root =  new Node<>(10);
		Node<Integer> node1 =  new Node<>(45);
		Node<Integer> node2 =  new Node<>(5);
		Node<Integer> node3 =  new Node<>(180);
		Node<Integer> node4 =  new Node<>(69);
		Node<Integer> node5 =  new Node<>(7);
		Node<Integer> node6 =  new Node<>(56);
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node5;
		
		node2.left = node4;
		node3.right = node6;
		
		levelOrder(root);
	}

}
