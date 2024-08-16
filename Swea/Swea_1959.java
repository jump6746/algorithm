package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Swea_1959 {

	static int testCase;
	static int N;
	static int M;
	static int[] A;
	static int[] B;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			int length = Math.abs(B.length - A.length) + 1;
			long maxTotal = 0;
			
			if(A.length <= B.length) {
				for(int i=0; i<length; i++) {
					long total = 0;
					for(int j=0; j<A.length; j++) {
						total += A[j] * B[j+i];
					}
					if(maxTotal < total) {
						maxTotal = total;
					}
				}	
			}else {
				for(int i=0; i<length; i++) {
					long total = 0;
					for(int j=0; j<B.length; j++) {
						total += A[j+i] * B[j];
					}
					if(maxTotal < total) {
						maxTotal = total;
					}
				}
			}
			
			
			result.append("#" + t + " " + maxTotal + "\n");
		}
		System.out.println(result);
	}

}
