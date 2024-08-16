package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_10760 {

	static int testCase;
	static int N;
	static int M;
	static int[][] map;
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N+2][M+2];
			for(int i=0; i<N+2; i++) {
				Arrays.fill(map[i], 10);
			}
			
			for(int i=1; i<N+1; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<M+1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<M+1; j++) {
					int lowPlace = 0;
					for(int k=0; k<8; k++) {
						if(map[i][j] > map[i+dr[k]][j+dc[k]]) {
							lowPlace++;
						}
					}
					if(lowPlace >= 4) {
						count++;
					}
				}
			}
			
			result.append("#" + (t+1) + " " + count + "\n");
			
		}
		
		System.out.println(result);
	}

}
