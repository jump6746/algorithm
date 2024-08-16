package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1225 {

	static int testCase = 10;
	static int caseNumber;
	static int[] arr = new int[8];
	static Queue<Integer> password;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=0; t<testCase; t++) {
			caseNumber = Integer.parseInt(br.readLine());
			
			int minValue = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if( arr[i] < minValue) {
					minValue = arr[i];
				}
			}
			
			minValue = minValue - (minValue % 15) - 15;
			
			password = new LinkedList<>();
			for(int i=0; i<8; i++) {
				if(minValue >= 15) {
					password.offer(arr[i] - minValue);
				}else {
					password.offer(arr[i]);
				}
				
			}
			
			int decrease = 0;
			while(true) {
				int output = password.peek();
				
				if(output - decrease <= 0) {
					password.poll();
					password.offer(0);
					break;
				}else {
					password.poll();
					password.offer(output - decrease - 1);
				}
				
				decrease = (decrease + 1) % 5;
			}
			
			result.append("#" + caseNumber + " ");
			while(!password.isEmpty()) {
				result.append(password.poll() + " ");
			}
			result.append("\n");
		}
		System.out.println(result);
	}
}
