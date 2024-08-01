package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Swea_1954 {

	static int testCase = 3;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N;
	static int[][] board;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<testCase; i++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			
			int currentY = 0;
			int currentX = 0;
			int direction = 0;
			
			for(int j=1; j<=N*N; j++) {
				
				board[currentY][currentX] = j;
			
				int newY = currentY + dr[direction];
				int newX = currentX + dc[direction];
				
				if(newY >= N || newY < 0 || newX >= N 
						|| newX < 0 || board[newY][newX] > 0) {
					direction = (direction + 1) % 4;
				}
			
				currentY = currentY + dr[direction];
				currentX = currentX + dc[direction];
			}
			
			result.append("#" + (i+1) + "\n");
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					result.append(board[j][k] + " ");
				}
				result.append("\n");
			}
		}
		System.out.println(result.toString());
		
	}

}
