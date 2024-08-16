package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Swea_1248 {

	static class Node{
		
		Node parent;
		Node left;
		Node right;
		int data;
		
		public Node(int data, Node parent) {
			this.data = data;
			this.parent = parent;
		}
	}
	
	static int testCase;
	static int V;
	static int E;
	static int A;
	static int B;
	static List<Node> aParents;
	static List<Node> bParents;
	static int treeSize;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			Node[] nodes = new Node[V];
			for(int i=0; i<V; i++) {
				nodes[i] = new Node(i+1, null);
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<V; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int data = Integer.parseInt(st.nextToken());
				
//				nodes[data - 1] = new Node(data, nodes[parent - 1]);
				nodes[data - 1].parent = nodes[parent - 1];
				
				if(nodes[parent - 1].left != null) {
					nodes[parent - 1].right = nodes[data - 1];
				}else {
					nodes[parent - 1].left = nodes[data - 1];
				}
			}
			
			// 가장 가까운 공통 조상
			int sameParent = 1;
			aParents = new ArrayList<>();
			findParent(nodes[A - 1], aParents);
			
			bParents = new ArrayList<>();
			findParent(nodes[B - 1], bParents);
			
			for(int i=0; i<aParents.size(); i++) {
				if(bParents.contains(aParents.get(i))) {
					sameParent = aParents.get(i).data;
					break;
				}
			}
			
			// 공통 조상을 루트로 하는 서브 트리 크기 
			treeSize = 0;
			findSize(nodes[sameParent - 1]);
			
			result.append("#" + t + " " + sameParent + " " + treeSize + "\n");
		}
		
		System.out.println(result);
	}
	
	static void findParent(Node node, List<Node> list){
		
		if(node.parent != null) {
			list.add(node.parent);
			findParent(node.parent, list);
		}
	}
	
	static void findSize(Node node) {
		treeSize++;
		
		if(node.left != null) {
			findSize(node.left);
			
		}
		if(node.right != null) {
			findSize(node.right);
		}
	}
	
	
	
}
