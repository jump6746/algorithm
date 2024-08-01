package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj_1940{
	
	static int N;
	static int M;
	static int[] materials;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		materials = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			materials[i] = Integer.parseInt(st.nextToken());
		}
		
		int leftIndex = 0;
		int rightIndex = 1;
		int count = 0;
		
		while(leftIndex < N - 1) {
			
			if(materials[leftIndex] + materials[rightIndex] == M) {
				if(rightIndex < N - 1) {
					rightIndex++;
				}else {
					leftIndex++;
					rightIndex = leftIndex + 1;
				}
				count++;
			}else {
				if(rightIndex < N - 1) {
					rightIndex++;
				}else {
					leftIndex++;
					rightIndex = leftIndex + 1;
				}
			}
			
		}
		
		System.out.println(count);
	}

}
