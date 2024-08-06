package algol0729;

import java.util.Arrays;

public class NextPerm {
	
	static int[] p = {1,2,3,4,5};
	static int N;
	static int count;

	public static void main(String[] args) {
		N = p.length;
		count = 0;
		do {
			count++;
			System.out.println(Arrays.toString(p));
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
