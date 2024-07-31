package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Swea_1204 {
	static int testCase;
	static int caseNumber;
	static int[] scoreBoard;
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCase; i++) {
			caseNumber = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			scoreBoard = new int[101];
			
			for(int j=0; j<1000; j++) {
				int score = Integer.parseInt(st.nextToken());
				scoreBoard[score] += 1;
			}
			
			int maxCount = Integer.MIN_VALUE;
			int index = 0;
			
			for(int j=0; j<101; j++) {
				if(scoreBoard[j] >= maxCount) {
					maxCount = scoreBoard[j];
					index = j;
				}
			}
			
			System.out.println(Arrays.toString(scoreBoard));
			result.append("#" + caseNumber + " ");
			result.append(index + "\n");
		}
		System.out.println(result.toString());
	}

}
