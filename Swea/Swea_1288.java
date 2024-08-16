package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class Swea_1288 {
	
	static int testCase;
	static int number;
	static Set<Integer> container;
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			number = Integer.parseInt(br.readLine());
			container = new HashSet<>();
			
			int count = 0;
			
			
			while(container.size() < 10) {
				int tempNum = number * (count+1);
				
				while(tempNum > 0) {
					int num = tempNum % 10;
					container.add(num);
					tempNum /= 10;
				}
				count++;
				
			}
			
			result.append("#" + t + " " + number*count + "\n");
		}
		System.out.println(result);
	}

}
