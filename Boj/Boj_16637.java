package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Boj_16637 {

	static int max = Integer.MIN_VALUE;
	static int length;
	static char[] commands;

	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		length = Integer.parseInt(br.readLine());
		commands = br.readLine().toCharArray();
		
		findMax(2, commands[0] - '0');
		
		System.out.println(max);
	}
	
	static void findMax(int index, int result) {
		
		if(index >= length) {
			if(max < result) {
				max = result;
			}
			return;
		}
		
		// 괄호를 쓰는 경우
		if(index + 2 < length) {
			int numA = commands[index] - '0';
			int numB = commands[index+2] - '0';
			char operator = commands[index+1];
			int next = calculate(numA, operator, numB);
			
			findMax(index+4, calculate(result, commands[index-1], next));
		}
		// 괄호를 안 쓰는 경우
		
		findMax(index+2, calculate(result, commands[index-1], commands[index] - '0'));
	
	}

	static int calculate(int numA, char operator, int numB) {
		
		int result = 0;
		
		switch(operator) {
			case '-':
				result = numA - numB;
				break;
			case '+':
				result = numA + numB;
				break;
			case '*':
				result = numA * numB;
				break;
		}
		
		return result;
	}
}
