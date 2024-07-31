package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_2063 {
	static int N;
	static int[] arr;
	static int maxNum = Integer.MIN_VALUE;
	
	static int[] countingSort(int[] path) {
		int[] sArr = new int[maxNum+1];
		int[] tArr = new int[sArr.length];
		int[] newArr = new int[path.length];
		for(int i=0; i<arr.length; i++) {
			sArr[path[i]] += 1;
		}
		
		int total = 0;
		for(int i=0; i<sArr.length; i++) {
			total += sArr[i];
			tArr[i] = total;
		}
		
		for(int i=0; i<path.length; i++) {
			newArr[tArr[path[i]] - 1] = path[i];
			tArr[path[i]] -= 1;
		}
		
		return newArr;
	};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > maxNum) {
				maxNum = arr[i];
			}
		}
		
		int[] result = countingSort(arr);
		
		System.out.println(result[N / 2]);
	}

}
