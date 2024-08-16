package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_7102 {

	static int testCase;
	static int N;
	static int M;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<testCase; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(M > N) {
				int temp = M;
				M = N;
				N = temp;
			}
			
			result.append("#" + (t+1) + " ");
			for(int i=M+1; i<=N+1; i++) {
				result.append(i + " ");
			}
			result.append("\n");
		}
		
		System.out.println(result);
	}

}
