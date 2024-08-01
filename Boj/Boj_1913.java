package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Boj_1913 {

	static int N;
	static int target;
	static int[][] board;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		target = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		int currentY = N / 2;
		int currentX = N / 2;
		int targetY = 0;
		int targetX = 0;
		int direction = 0;
		
		// 초기값 설정
		board[currentY][currentX] = 1;
		
		if(target == 1) {
			targetY = currentY + 1;
			targetX = currentX + 1;
		}
		
		for(int i=2; i<=N*N; i++) {
			// 이동
			currentY += dr[direction];
			currentX += dc[direction];
			
			board[currentY][currentX] = i;
			
			if(target == i) {
				targetY = currentY + 1;
				targetX = currentX + 1;
			}
			
			// 방향 전환 지점 좌표
			int newY = currentY + dr[(direction + 1) % 4];
			int newX = currentX + dc[(direction + 1) % 4];
			
			// 방향 전환 지점 좌표 0이면 회전
			if(board[newY][newX] == 0) {
				direction = (direction + 1) % 4;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				result.append(board[i][j] + " ");
			}
			result.append("\n");
		}
		result.append(targetY + " ").append(targetX);
		
		System.out.println(result.toString());
	}

}
