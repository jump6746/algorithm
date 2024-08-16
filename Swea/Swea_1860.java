package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Swea_1860 {

	static int testCase;
	static int N;
	static int M;
	static int K;
	static PriorityQueue<Integer> people;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			people = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				people.offer(Integer.parseInt(st.nextToken()));
			}
			
			result.append("#" + (t+1) + " ");
			int taken = 0;
			boolean resultValid = true;
			while(!people.isEmpty()) {
				int valid = people.peek() / M * K - taken;
				
				if(valid <= 0) {
					resultValid = false;
				}
				
				people.poll();
				taken++;
			}
			if(resultValid) {
				result.append("Possible\n");
			}else {
				result.append("Impossible\n");
			}
			
		}
		System.out.println(result);

	}
}
