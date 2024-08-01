package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Swea_1216 {

	static int testCase = 10;
	static int caseNumber;
	static char[][] board = new char[100][100];
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<testCase; t++) {
	
			
			caseNumber = Integer.parseInt(br.readLine());
			
			for(int i=0; i<100; i++) {
				board[i] = br.readLine().toCharArray();
			}
			int N = 100;
			int length = 2;
			
			for(int M=2; M<100; M++) {
				
				xx:
				for(int i=0; i<N; i++) {
					for(int j=0; j<N-M+1; j++) {
						boolean isS = true;

						for(int k=0; k<M/2; k++) {
							if(board[j+k][i] != board[j+M-1-k][i]) {
								isS = false;
								break;
							}
						}
						
						if(isS) {
							length = M;
							break xx;
						}
					}
				}
				// 로직 시작
				yy:
				for(int i=0; i<N; i++) {
					for(int j=0; j<N-M+1; j++) {
						boolean isS = true;

						for(int k=0; k<M/2; k++) {
							if(board[i][j+k] != board[i][j+M-1-k]) {
								isS = false;
								break;
							}
						}
						
						if(isS) {
							length = M;
							break yy;
						}
					}
				}
				
			}
			
			result.append("#"+caseNumber+" "+length+"\n");
		}
		System.out.println(result);
	}	

}
