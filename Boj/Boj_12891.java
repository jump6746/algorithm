package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj_12891 {

	static int S;
	static int P;
	static char[] words;
	static int[] rule = new int[4];
	static int[] ruleCount = new int[4];
	static int ruleCheck = 0;
	static int count = 0;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		words = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			rule[i] = Integer.parseInt(st.nextToken());
			if(rule[i] == 0) {
				ruleCheck++;
			}
		}

		for(int i=0; i<P; i++) {
			Add(words[i]);
		}
		
		if(ruleCheck == 4) {
			count++;
		}
		
		for(int i=P; i<S; i++) {
			int j = i - P;
			Add(words[i]);
			Remove(words[j]);
			if(ruleCheck == 4) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	static void Add(char word) {
		switch(word) {
			case 'A':
				ruleCount[0] += 1;
				if(ruleCount[0] == rule[0]) {
					ruleCheck += 1;
				}
				break;
			case 'C':
				ruleCount[1] += 1;
				if(ruleCount[1] == rule[1]) {
					ruleCheck += 1;
				}
				break;
			case 'G':
				ruleCount[2] += 1;
				if(ruleCount[2] == rule[2]) {
					ruleCheck += 1;
				}
				break;
			case 'T':
				ruleCount[3] += 1;
				if(ruleCount[3] == rule[3]) {
					ruleCheck += 1;
				}
				break;
		}
	}
	
	static void Remove(char word) {
		switch(word) {
		case 'A':
			if(ruleCount[0] == rule[0]) {
				ruleCheck -= 1;
			}
			ruleCount[0] -= 1;
			break;
		case 'C':
			if(ruleCount[1] == rule[1]) {
				ruleCheck -= 1;
			}
			ruleCount[1] -= 1;
			break;
		case 'G':
			if(ruleCount[2] == rule[2]) {
				ruleCheck -= 1;
			}
			ruleCount[2] -= 1;
			break;
		case 'T':
			if(ruleCount[3] == rule[3]) {
				ruleCheck -= 1;
			}
			ruleCount[3] -= 1;
			break;
		}
	}

}
