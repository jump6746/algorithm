package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1265 {

	static int testCase;
	static int N;
	static int P;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			
			int part = N / P;
			int rest = N % P;
			long total = 1;
			
			while(P > 0) {
				if(rest > 0) {
					total = total * (part + 1);
				}else {
					total = total * part;
				}
				P--;
				rest--;
			}
			
			result.append("#" + (t+1) + " " + total + "\n");
			
		}
		System.out.println(result);
	}

}
