package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj_1253 {
	
	static int N;
	static int[] numbers;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		

		int count = 0;
		
		for(int i=0; i<N; i++) {
			int leftIndex = 0;
			int rightIndex = 1;
			while(leftIndex < N - 1) {
				if(numbers[leftIndex] + numbers[rightIndex] == numbers[i]) {
					if(rightIndex != i && leftIndex != i) {
						if(rightIndex < N - 1) {
							rightIndex++;
						}else {
							leftIndex++;
							rightIndex = leftIndex + 1;
						}
						count++;
						break;
					}
					break;
				}else {
					if(rightIndex < N - 1) {
						rightIndex++;
					}else {
						leftIndex++;
						rightIndex = leftIndex + 1;
					}
				}
				
			}
		}
		
		System.out.println(count);
	}


}
