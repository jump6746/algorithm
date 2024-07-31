package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Boj_10986 {
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
        
        int[] count = new int[M];
		
        int sum = 0;
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            sum = (sum + number) % M;
            count[sum]++;
        }
        
        long answer = count[0];
        for(int i=0; i<M; i++){
            answer += (long) count[i] * (count[i] - 1) / 2;
        }
        
		
		System.out.println(answer);
		
	}
	
}