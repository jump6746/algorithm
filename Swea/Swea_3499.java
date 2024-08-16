package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_3499 {

	static int testCase;
	static int caseLength;
	static String[] cards;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			caseLength = Integer.parseInt(br.readLine());
			cards = br.readLine().split(" ");
			result.append("#" + (t+1) + " ");
			for(int i=0; i<(caseLength+1) / 2; i++) {
				result.append(cards[i] + " ");
				if(i + (caseLength+1) / 2 < caseLength) {
					result.append(cards[i + (caseLength+1) / 2] + " ");
				}
			}
			result.append("\n");
		}
		
		System.out.println(result);
	}

}
