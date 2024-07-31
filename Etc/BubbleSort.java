package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BubbleSort {
	
	static int testCase;
	static int N;
	static int[] arr;
	static int count;
	static StringBuilder result = new StringBuilder();
	
	static void bubbleSort() {
		for(int i=0; i<N; i++) {
			boolean countValid = false;
			
			for(int j=0; j<N-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					countValid = true;
				}
			}
			
			if(countValid) {
				count++;
			}else {
				break;
			}
			result.append(count).append("\n");
			result.append(Arrays.toString(arr)).append("\n");
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCase; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			count = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			result.append("#"+(i+1)+"\n");
			bubbleSort();
		}
		
		System.out.println(result.toString());
	}

}
