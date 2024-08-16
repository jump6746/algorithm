package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Swea_2930 {

	static int testCase;
	static int orderLength;
	static List<Integer> heapTree;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			result.append("#" + t + " ");
			orderLength = Integer.parseInt(br.readLine());
			StringTokenizer st;
			heapTree = new ArrayList<Integer>();
			
			for(int i=0; i<orderLength; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				if(command == 1) {
					int order = Integer.parseInt(st.nextToken());
					add(order);
				}else {
					removeParent();
				}
			}
			result.append("\n");
		}
		
		System.out.println(result);

	}
	
	// 힙에 추가
	static void add(int num) {
		heapTree.add(num);
		int size = heapTree.size();
		int parentIndex = (size-1) / 2;
		int myIndex = (size - 1);
		
		
		if(heapTree.size() > 1) {
			sortAddHeap(myIndex, parentIndex);
		}
	}
	
	// 추가된 힙 정렬
	static void sortAddHeap(int myIndex, int parentIndex) {
		if(heapTree.get(myIndex) > heapTree.get(parentIndex)) {
			int myData = heapTree.get(myIndex);
			int parentData = heapTree.get(parentIndex);
			
			heapTree.set(myIndex, parentData);
			heapTree.set(parentIndex, myData);
		}else {
			return ;
		}
		myIndex = parentIndex;
		parentIndex = myIndex / 2;
		sortAddHeap(myIndex, parentIndex);
	}
	
	// 힙에서 부모 삭제
	static void removeParent() {
		if(heapTree.isEmpty()) {
			result.append("-1 ");
		}else {
			int parent = heapTree.get(0);
			result.append(parent + " ");
			
			if(heapTree.size() > 1) {
				heapTree.set(0, heapTree.get(heapTree.size()-1));
				heapTree.remove(heapTree.size()-1);
				
				int myIndex = 0;
				int leftChildIndex = 1;
				int rightChildIndex = 2;
				
				sortRemoveHeap(myIndex, leftChildIndex, rightChildIndex);
			}
		}
		
	}
	
	// 삭제된 힙 정렬
	static void sortRemoveHeap(int myIndex, int leftChildIndex, int rightChildIndex) {
		int leftChildData = 0;
		int rightChildData = 0;
		int myData = heapTree.get(myIndex);
		
		if(leftChildIndex < heapTree.size()) {
			leftChildData = heapTree.get(leftChildIndex);
		}else {
			return;
		}
		if(rightChildIndex < heapTree.size()) {
			rightChildData = heapTree.get(rightChildIndex);
		}else {
			return;
		}
	
		if(leftChildData >= rightChildData) {
			if(myData < leftChildData) {
				heapTree.set(myIndex, leftChildData);
				heapTree.set(leftChildIndex, myData);
				myIndex = leftChildIndex;
			}
			
		}else {
			if(myData < rightChildData) {
				heapTree.set(myIndex, rightChildData);
				heapTree.set(rightChildIndex, myData);
				myIndex = rightChildIndex;
			}
			
		}
		
		leftChildIndex = (myIndex + 1) *  2;
		rightChildIndex = leftChildIndex + 1;
		
		if(leftChildIndex >= heapTree.size()) {
			return;
		}
		
		sortRemoveHeap(myIndex, leftChildIndex, rightChildIndex);
	}
}
