package algol0729;

import java.util.Arrays;

public class NC {
	
	static int[] p = {0,0,1,1,1};
	static int[] q = {1,2,3,4,5};
	static int N;
	static int count;

	public static void main(String[] args) {
		N = p.length;
		count = 0;
		do {
			count++;
			System.out.println(Arrays.toString(p));
			for(int i=0; i<N; i++) {
				if(p[i] == 1) {
					System.out.print(q[i] + " ");
				}
			}
			System.out.println("");
			System.out.println("===============");
		}while(np(N-1));
		
		System.out.println(count);
	}
	
	static boolean np(int size) {
		int i = size;
		while(p[i-1] >= p[i]) {
			i--;
		}
		if(i == 0) {
			return false;
		}
		int j = size;
		while(p[i-1] >= p[j]) {
			j--;
		}
		int t = p[j];
		p[j] = p[i-1];
		p[i-1] = t;
		
		int k = size;
		while(i < k) {
			t = p[i];
			p[i] = p[k];
			p[k] = t;
			i++;
			k--;
		}
		
		return true;
	}

}
