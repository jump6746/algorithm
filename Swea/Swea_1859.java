package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Swea_1859 {

	static int testCase;
	static int N;
	static int[] prices;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			N = Integer.parseInt(br.readLine());
			prices = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			long total = 0;
			int maxPrice = 0;
			for(int i=N-1; i>=0; i--) {
				
				if(prices[i] > maxPrice) {
					maxPrice = prices[i];
				}else {
					total += maxPrice - prices[i];
				}
			}
			
			result.append("#" + t + " " + total + "\n");
		}
		System.out.println(result);
	}

}
