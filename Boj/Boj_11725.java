package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj_11725 {

	static int nodeCount;
	
	class Node{
		int parent;
		int self;
		
		public Node(int self) {
			this.self = self;
		}
		
		public Node(int parent, int self) {
			this.parent = parent;
			this.self = self;
		}
	}
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		nodeCount = Integer.parseInt(br.readLine());
		
		Node[] nodes = new Node[nodeCount];
		
		for(int i=0; i<nodeCount; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(A == 1 || nodes[A].parent > 0) {
				nodes[B].parent = A;
			}
		}

	}

}
