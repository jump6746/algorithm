package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Swea_6190 {

	static int testCase;
	static int N;
	static int[] nums;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			nums = new int[N];
			
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			int maxTotal = -1;
			
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					boolean valid = true;
					int number = nums[i] * nums[j];
					char[] numbs = Integer.toString(number).toCharArray();
					for(int k=1; k<numbs.length; k++) {
						if(numbs[k-1] > numbs[k]) {
							valid = false;
							break;
						}
					}
					if(valid) {
						if(number > maxTotal){
							maxTotal = number;
						}
					}
				}
			}
			
			result.append("#" + t + " " + maxTotal + "\n");
		}
		System.out.println(result);
	}

}
