package src.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import src.tree.GenericNode;

public class LevelOrder {
	
	public static void levelOrder(GenericNode<Integer> root) {
		
		Queue<GenericNode<Integer>> q = new LinkedList<>();
		q.add(root);
		
		ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int numOfNodesPerLevel = q.size();
			ArrayList<Integer> subList = new ArrayList<>();
			
			for(int i=0; i<numOfNodesPerLevel; i++) {
				GenericNode<Integer> curr = q.poll();
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
		
		GenericNode<Integer> root =  new GenericNode<>(10);
		GenericNode<Integer> genericNode1 =  new GenericNode<>(45);
		GenericNode<Integer> genericNode2 =  new GenericNode<>(5);
		GenericNode<Integer> genericNode3 =  new GenericNode<>(180);
		GenericNode<Integer> genericNode4 =  new GenericNode<>(69);
		GenericNode<Integer> genericNode5 =  new GenericNode<>(7);
		GenericNode<Integer> genericNode6 =  new GenericNode<>(56);
		
		root.left = genericNode1;
		root.right = genericNode2;
		
		genericNode1.left = genericNode3;
		genericNode1.right = genericNode5;
		
		genericNode2.left = genericNode4;
		genericNode3.right = genericNode6;
		
		levelOrder(root);
	}

}
