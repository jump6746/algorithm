package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Swea_1210 {
	
	static int testCase = 10;
	static int[][] board = new int[100][100];
	static int[] dr = {0, -1, 0};
	static int[] dc = {-1, 0, 1};
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<testCase; i++) {
			int caseNumber = Integer.parseInt(br.readLine());
			int currentY = 0;
			int currentX = 0;
			
			for(int j=0; j<100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<100; k++) {
					board[j][k] = Integer.parseInt(st.nextToken());
					if(board[j][k] == 2) {
						currentY = j;
						currentX = k;
					}
				}
			}
			
			int direction = 1;
			while(currentY > 0) {
				
				if(direction == 1) {
					if(currentX - 1 >= 0 && board[currentY][currentX - 1] == 1) {
						direction = 0;
					}else if( currentX + 1 < 100 && board[currentY][currentX + 1] == 1) {
						direction = 2;
					} 
				}else if(direction == 0) {
					if(board[currentY - 1][currentX] == 1) {
						direction = 1;
					}
				}else if(direction == 2) {
					if(board[currentY - 1][currentX] == 1) {
						direction = 1;
					}
				}
				
				currentY = currentY + dr[direction];
				currentX = currentX + dc[direction];
			}
			
			result.append("#" + caseNumber + " ");
			result.append(currentX + "\n");
		}	
		System.out.println(result.toString());
	}

}
