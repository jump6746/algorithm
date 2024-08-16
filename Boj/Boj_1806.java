package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Boj_1806 {

	static int N;
	static int S;
	static int minSize = Integer.MAX_VALUE;
	static int total;
	static Queue<Integer> container = new LinkedList<>();
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		total = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			total += input;
			container.offer(input);
			
			while(total - container.peek() >= S) {
				total -= container.poll();
			}
			
			if(total >= S) {
				int size = container.size();
				if(size < minSize) {
					minSize = size;
				}
			}
		}
		if(total < S) {
			minSize = 0;
		}
		
		System.out.println(minSize);
	}
}
