package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_최대분반 {

	static int testCase;
	static int N;
	static int min;
	static int max;
	static int minGap;
	static int[] scores;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			min = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
			scores = new int[N];
			result.append("#" + t + " ");
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(scores);
			minGap = Integer.MAX_VALUE;
			
			findMinScore(1, 2);
			if(minGap == Integer.MAX_VALUE) {
				result.append("-1\n");
			}else {
				result.append(minGap + "\n");
			}
		}
		
		System.out.println(result);
	}

	static void findMinScore(int score1, int score2) {
		if(score1 > scores[scores.length -1] - 2) {
			return;
		}
		if(score2 > scores[scores.length - 1]) {
			score1 += 1;
			score2 = score1 + 1;
		}
		
		int[] teamCount = new int[3];
		int gap = 0;
		
		for(int i=0; i<scores.length; i++) {
			if(scores[i] < score1) {
				teamCount[0]++;
			}else if(scores[i] >= score1 && scores[i] < score2) {
				teamCount[1]++;
			}else if(scores[i] >= score2) {
				teamCount[2]++;
			}
		}
		
		findMinScore(score1, score2 + 1);
		
		for(int i=0; i<3; i++) {
			if(teamCount[i] < min || teamCount[i] > max) {
				
				return;
			}
		}
		
		Arrays.sort(teamCount);
		gap = teamCount[2] - teamCount[0];
		
		if(gap < minGap) {
			minGap = gap;
		}
		
	}
}
