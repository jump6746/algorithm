package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_21131 {

	static int testCase;
	static int length;
	static boolean[] booleanMap;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			length = Integer.parseInt(br.readLine());
			booleanMap = new boolean[length];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<length; i++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == i+1) {
					booleanMap[i] = true;
				}else {
					booleanMap[i] = false;
				}
			}
			
			for(int i=1; i<length; i++) {
				br.readLine();
			}
			int count = 0;
			count = swap(count);
			
			result.append(count+"\n");
		}
		System.out.println(result);
	}
	
	static int swap(int count) {
		for(int i=length-1; i>0; i--) {
			if(!booleanMap[i]) {
				count++;
				for(int j=1; j<=i; j++) {
					booleanMap[j] = !booleanMap[j];
				}
			}
		}
		return count;
	}
}
