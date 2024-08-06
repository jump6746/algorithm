package algol0729;

import java.util.Scanner;

public class Swea_1217 {

	static int testCase = 10;
	static int caseNumber;
	static int N;
	static int M;
	
	public static void main(String[] args){
		
		Scanner scann = new Scanner(System.in);
		
		for(int t=0; t<testCase; t++) {
			caseNumber = scann.nextInt();
			
			N = scann.nextInt();
			M = scann.nextInt();
			
			System.out.println("#" + (t+1) + " " + power(N,M));
		}
		
	}
	
	private static int power(int N, int M) {
		
		if(M == 0) return 1;
		
		return N * power(N, M - 1);
	}

}
