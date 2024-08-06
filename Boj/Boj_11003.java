package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Boj_11003 {

	static int N;
	static int L;
	static int[] arr;
	static StringBuilder result = new StringBuilder();
	static Deque<Integer> deque = new ArrayDeque<>();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		deque.addLast(arr[0]);
		result.append(arr[0] + " ");
		if(arr[1] > deque.peekFirst()) {
			deque.addLast(arr[1]);
		}else {
			deque.addFirst(arr[1]);
		}
		for(int i=2; i<N; i++) {
			if(deque.size() < L) {
				if(arr[i] < deque.peekFirst()) {
					deque.addFirst(arr[i]);
				}else if(arr[i] < deque.peekLast()) {
					
				}
			}
		}
		
		System.out.println(result);
	}

}
