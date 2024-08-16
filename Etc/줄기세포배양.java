package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 줄기세포배양 {
	
	static int testCase;
	static int N;
	static int M;
	static int K;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static StringBuilder result = new StringBuilder();
	static class Cell{
		int state;
		int coolTime;
		boolean live;
		
		public Cell(int coolTime, boolean live) {
			this.coolTime = coolTime;
			this.state = coolTime;
			this.live = live;
		}
	}

	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			Cell[][] map = new Cell[500][500];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					int coolTime = Integer.parseInt(st.nextToken());
					if(coolTime > 0) {
						map[i+200][j+200] = new Cell(coolTime, true);
					}
				}
			}
			
			for(int k=0; k<K; k++) {
				for(int i=1; i<499; i++) {
					for(int j=1; j<499; j++) {
						if(map[i][j] != null) {
							
								
							if(Math.abs(map[i][j].coolTime) == map[i][j].state) {
									map[i][j].live = false;
							}
							if(map[i][j].coolTime == 0) {
								for(int d=0; d<4; d++) {
									if(map[i + dr[d]][j + dc[d]] == null) {
										map[i + dr[d]][j + dc[d]] = new Cell(map[i][j].state, true);
									}else {
										if(map[i + dr[d]][j + dc[d]].state == map[i + dr[d]][j + dc[d]].coolTime) {
											if(map[i][j].state > map[i + dr[d]][j + dc[d]].state) {
												map[i + dr[d]][j + dc[d]] = new Cell(map[i][j].state, true);
											}
										}
									}
								}
							}
							map[i][j].coolTime--;
						}
					}
				}
				System.out.println(k);
			}
			
			int count = 0;
			
			for(int i=0; i<500; i++) {
				for(int j=0; j<500; j++) {
					if(map[i][j] != null && map[i][j].live) {
						System.out.println("i : " + i + " j : " + j + " cell Live : " + map[i][j].live);
						count++;
					}
				}
			}
			
			result.append("#" + t + " " + count + "\n");
		}
		
		System.out.println(result);
	}

}
