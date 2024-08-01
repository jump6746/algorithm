package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1209 {

	static int testCase = 10;
	static int[][] board = new int[100][100];
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<testCase; i++) {
			int caseNumber = Integer.parseInt(br.readLine());
			
			
			for(int j=0; j<100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<100; k++) {
					board[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxTotal = Integer.MIN_VALUE;
			int lTotal = 0;
			int rTotal = 0;
			
			for(int j=0; j<100; j++) {
				int rowTotal = 0;
				int colTotal = 0;
				for(int k=0; k<100; k++) {
					rowTotal += board[j][k];
					colTotal += board[k][j];
				}
				if(rowTotal > maxTotal) {
					maxTotal = rowTotal;
				}
				if(colTotal > maxTotal) {
					maxTotal = colTotal;
				}
				lTotal += board[j][j];
				rTotal += board[j][99-j];
			}
			
			if(lTotal > maxTotal) {
				maxTotal = lTotal;
			}
			if(rTotal > maxTotal) {
				maxTotal = rTotal;
			}
			result.append("#" + caseNumber + " ");
			result.append(maxTotal + "\n");
		}
		System.out.println(result.toString());
	}

}
