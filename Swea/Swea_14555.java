package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Swea_14555 {

	static int testCase;
	static char[] field;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			field = br.readLine().toCharArray();
			int count = 0;
			
			for(int i=0; i<field.length - 1; i++) {
				if(field[i] == '|') {
					if(field[i+1] == ')') {
						count++;
					}
				}else if(field[i] == '(') {
					if(field[i+1] == '|' || field[i+1] == ')') {
						count++;
					}
				}
			}
			
			result.append("#" + (t+1) + " " + count + "\n");
		}
		
		System.out.println(result);
	}

}
