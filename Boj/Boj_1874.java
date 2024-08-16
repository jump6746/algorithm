package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Boj_1874 {

	static int testLength;
	static Stack<Integer> stack = new Stack<>();
	static boolean[] check;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testLength = Integer.parseInt(br.readLine());
		check = new boolean[testLength + 1];
		boolean sequenceValid = true;
		
		stack.push(0);
		
		for(int t=0; t<testLength; t++) {
			
			int output = Integer.parseInt(br.readLine());
			
			if(sequenceValid) {
				if(stack.peek() < output) {
					for(int i=stack.peek()+1; i<=output; i++) {
						if(!check[i]) {
							stack.push(i);
							check[i] = true;
							result.append("+\n");
						}
					}
					stack.pop();
					result.append("-\n");
				}else if(stack.peek() == output) {
					stack.pop();
					result.append("-\n");
				}else if(stack.peek() > output) {
					result = new StringBuilder();
					result.append("NO");
					sequenceValid = false;
				}
			}
			
		}
		
		System.out.println(result);
		
	}

}
