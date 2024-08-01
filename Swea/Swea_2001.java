package algol0729;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_2001 {

	static int testCase;
	static int N;
	static int M;
	static int[][] board;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int extraSize = M - 1;
			board = new int[N + extraSize * 2][N + extraSize * 2];
			
			for(int j=extraSize; j<N+extraSize; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=extraSize; k<N+extraSize; k++) {
					board[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxTotal = Integer.MIN_VALUE;
			for(int j=0; j<N+extraSize; j++) {
				for(int k=0; k<N+extraSize; k++) {
					int total = 0;
					for(int l=j; l<j+M; l++) {
						for(int m=k; m<k+M; m++) {
							total += board[l][m];
						}
					}
					if(total > maxTotal) {
						maxTotal = total;
					}
				}
			}
			
			result.append("#" + (i+1) + " ");
			result.append(maxTotal + "\n");
		}
		
		System.out.println(result.toString());
		
	}

}
