package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj_14719 {

	static int H;
	static int W;
	static int[] walls;
	static int[] wallGap;
	static boolean wallValid = false;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		walls = new int[W];
		
		int wallBeginIndex = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			walls[i] = Integer.parseInt(st.nextToken());
			if(!wallValid && walls[i] > 0) {
				wallBeginIndex = i;
			}
		}
		
		// 벽 생성 : 2, 벽 감소 : 1, 벽 증가 : 0, 벽 유지 : -1
		wallGap = new int[W - 1];
		
		for(int i=0; i<W-1; i++) {
			if(!wallValid && walls[i] > 0) {
				
			}
			if(walls[i] > walls[i+1]) {
				
			}else if(walls[i] < walls[i+1]){
				
			}

			
		}
	}

}
