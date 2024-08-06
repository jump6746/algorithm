package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Swea_1222 {

	static int testCase = 10;
	static int caseLength;
	static Stack<Character> stack;
	static Stack<Character> operators;
	static Stack<Character> calculators;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<testCase; t++) {
			caseLength = Integer.parseInt(br.readLine());
			stack = new Stack<>();
			operators = new Stack<>();
			char[] input = br.readLine().toCharArray();
			
			for(int i=0; i<input.length; i++) {
				if(Character.isDigit(input[i])) {
					stack.push(input[i]);
				}else {
					if(operators.empty()) {
						operators.push(input[i]);
					}else {
						if(input[i] == '+') {
							if(operators.peek() != '(') {
								stack.push(operators.pop());
								operators.push(input[i]);
							}else {
								operators.push(input[i]);
							}
						}else if(input[i] == '*') {
							if(operators.peek() == '*') {
								stack.push(operators.pop());
								operators.push(input[i]);
							}else {
								operators.push(input[i]);
							}
						}else if(input[i] == ')') {
							while(operators.peek() != '(') {
								stack.push(operators.pop());
							}
							operators.pop();
						}else {
							operators.push(input[i]);
						}
					}
				}
			}
			
			while(!operators.empty()) {
				stack.push(operators.pop());
			}
			calculators = new Stack<>();
			while(!stack.empty()) {
				calculators.push(stack.pop());
			}
			
			Stack<Integer> container = new Stack<>();
			
			while(!calculators.empty()) {
				if(Character.isDigit(calculators.peek())) {
					container.push(calculators.pop() - '0');
				}else {
					if(calculators.peek() == '+') {
						int numA = container.pop();
						int numB = container.pop();
						container.push(numA + numB);
						calculators.pop();
					}else if(calculators.peek() == '*') {
						int numA = container.pop();
						int numB = container.pop();
						container.push(numA * numB);
						calculators.pop();
					}
				}
			}
			result.append("#" + (t+1) + " " + container.pop() + "\n");
			
		
		}
		System.out.println(result);
	}

}
