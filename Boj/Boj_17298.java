package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Boj_17298 {
	
	static int caseLength;
	static int[] arr;
	static int[] answer;
	static Stack<Integer> container = new Stack<>();
	static StringBuilder result = new StringBuilder();
	

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		caseLength = Integer.parseInt(br.readLine());
		arr = new int[caseLength];
		answer = new int [caseLength];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<caseLength; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		container.push(0);
		for(int i=1; i<caseLength; i++) {
			while(!container.empty() && arr[container.peek()] < arr[i]) {
				answer[container.pop()] = arr[i];
			}	

			container.push(i);
		}
		
		while(!container.empty()) {
			answer[container.pop()] = -1;
		}
		
		
		for(int i=0; i<caseLength; i++) {
			result.append(answer[i] + " ");
		}
		
		System.out.println(result);
	}

}
