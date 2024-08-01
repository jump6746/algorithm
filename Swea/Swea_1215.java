package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Swea_1215 {
	
	static int T = 10;
	static int N = 8;
	static char[][] map;
	static int M;
	static int cnt;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=T; t++) {
			M = Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			cnt = 0;
			// 로직 시작
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-M+1; j++) {
					boolean isS = true;

					for(int k=0; k<M/2; k++) {
						if(map[j+k][i] != map[j+M-1-k][i]) {
							isS = false;
							break;
						}
					}
					
					if(isS) cnt++;
				}
			}
			// 로직 시작
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-M+1; j++) {
					boolean isS = true;

					for(int k=0; k<M/2; k++) {
						if(map[i][j+k] != map[i][j+M-1-k]) {
							isS = false;
							break;
						}
					}
					
					if(isS) cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
		
	}

}
