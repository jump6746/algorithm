package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2798 {

	static int N;
	static int M;
	static int[] cards;
	static int[] combination;
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cards = new int[N];
		combination = new int[N];
		
		for(int i=combination.length - 3; i<combination.length; i++) {
			combination[i] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		int max = -1;
		do {
			int result=0;
			for(int i=0; i<N; i++) {
				if(combination[i] == 1) {
					result += cards[i];
				}
			}
			if(result <= M) {
				max = Math.max(result, max);
			}
		}while(np(N-1));
		System.out.println(max);
	}
	
	static boolean np(int size) {
		int i = size;
		while(i>0 && combination[i-1] >= combination[i]) {
			i--;
		}
		if(i==0) {
			return false;
		}
		int j=size;
		while(combination[i-1] >= combination[j]) {
			j--;
		}
		
		int temp=combination[i-1];
		combination[i-1]=combination[j];
		combination[j]=temp;
		
		int k=size;
		while(i < k) {
			temp=combination[i];
			combination[i]=combination[k];
			combination[k]=temp;
			i++;
			k--;
		}
		
		return true;
	}

}
