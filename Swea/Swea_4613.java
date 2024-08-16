package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Swea_4613 {

	static int testCase;
	static int N;
	static int M;
	static char[][] map;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		testCase = Integer.parseInt(br.readLine());

		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			
			int total = 0;
			
			
			
			
			result.append("#" + t + " " + total + "\n");
		}
		System.out.println(result);
	}

}
