package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Swea_1218 {

	static int testCase = 10;
	static int caseLength;
	static char[] words;
	static Stack<Character> stack;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<testCase; t++) {
			stack = new Stack<>();
			caseLength = Integer.parseInt(br.readLine());
			words = new char[caseLength];
			words = br.readLine().toCharArray();
			for(int i=0; i<words.length; i++) {
				char input = words[i];
				
				if(!stack.empty()) {
					char top = stack.peek();
					if(top == '(' && input == ')') {
						stack.pop();
						continue;
					}else if(top == '[' && input == ']') {
						stack.pop();
						continue;
					}else if(top == '{' && input == '}') {
						stack.pop();
						continue;
					}else if(top == '<' && input == '>') {
						stack.pop();
						continue;
					}
				}		
				
				stack.push(input);
			}
			
			result.append("#" + (t+1) + " ");
			if(stack.empty()) {
				result.append(1 + "\n");
			}else {
				result.append(0 + "\n");
			}
		}
		System.out.println(result);

	}

}
