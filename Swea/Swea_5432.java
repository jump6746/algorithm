package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Swea_5432 {

	static int testCase;
	static char[] commands;
	static int total;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			
			commands = br.readLine().toCharArray();
			total = 0;
			int count = 0;
			for(int i=0; i<commands.length - 1; i++) {
				if(commands[i] == '(') {
					if(commands[i + 1] == '(') {
						count++;
						total++;
					}else {
						total += count;
						i++;
					}
				}
				else {
					count--;
				}
			}
			result.append("#" + t + " " + total + "\n");
		}
		System.out.println(result);
	}
}
