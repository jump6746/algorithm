package algol0729;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Swea_8931 {

	static int testCase;
	static int K;
	static Stack<Integer> stack;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			stack = new Stack<>();
			K = Integer.parseInt(br.readLine());
			int total = 0;
			
			for(int i=0; i<K; i++) {
				int input = Integer.parseInt(br.readLine());
				if(input == 0) {
					stack.pop();
				}else {
					stack.push(input);
				}
			}
			
			while(!stack.empty()) {
				total += stack.pop();
			}
			
			result.append("#"+(t+1)+" ");
			result.append(total+"\n");
		}
		
		System.out.println(result);
	}

}
