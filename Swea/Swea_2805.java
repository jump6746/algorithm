package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Swea_2805 {

	static int testCase;
	static int length;
	static char[][] map;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t=0; t<testCase; t++) {
			length = Integer.parseInt(br.readLine());
			map = new char[length][length];
			
			for(int i=0; i<length; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int total = 0;
			int step = 0;
			int start = length / 2;
			int finish = length / 2;
			int plus = 1;
			while(step < length) {
				for(int i=start; i<=finish; i++) {
					total += map[step][i] - '0';
				}
				start -= plus;
				finish += plus;
				step++;
				if(step == length / 2) {
					plus = -1;
				}
			};
			
			result.append("#" + (t+1) + " " + total +"\n");
		}
		System.out.println(result);
	}
}
