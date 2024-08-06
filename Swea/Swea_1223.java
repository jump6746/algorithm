package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Swea_1223{
	
	static int testCase = 10;
	static int commandLength;
	static Stack<Character> operators;
	static Stack<Character> calculators;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<testCase; t++) {
			operators = new Stack<>();
			calculators = new Stack<>();
			commandLength = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			
			for(int i=0; i<commandLength; i++) {
				if(Character.isDigit(input[i])) {
					calculators.push(input[i]);
				}else {
					if(operators.empty()) {
						operators.push(input[i]);
					}else {
						if(input[i] == '*') {
							if(operators.peek() == '*') {
								calculators.push(input[i]);
							}else {
								operators.push(input[i]);
							}
						}else if(input[i] == '+') {
							if(operators.peek() == '*') {
								calculators.push(operators.pop());
								if(!operators.empty()) {
									calculators.push(operators.pop());
								}
								operators.push(input[i]);
							}else {
								calculators.push(input[i]);
							}
						}
					}
				}
			}
			while(!operators.empty()) {
				calculators.push(operators.pop());
			}
			
			while(!calculators.empty()) {
				operators.push(calculators.pop());
			}
			Stack<Integer> container = new Stack<>();
			while(!operators.empty()) {
				if(Character.isDigit(operators.peek())) {
					container.push(operators.pop() - '0');
				}else {
					if(operators.peek() == '+') {
						int numA = container.pop();
						int numB = container.pop();
						container.push(numA + numB);
						operators.pop();
					}else if(operators.peek() == '*') {
						int numA = container.pop();
						int numB = container.pop();
						container.push(numA * numB);
						operators.pop();
					}
				}
			}
			result.append("#" + (t+1) + " ");
			result.append(container.pop() + "\n");
		}
		System.out.println(result);
	}
}