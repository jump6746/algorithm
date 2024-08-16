package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Boj_1377 {

	static int length;
	static int[] container;
	//	static Queue<Integer> container = new LinkedList<>();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		length = Integer.parseInt(br.readLine());
		container = new int[length];
		
		for(int i=0; i<length; i++) {
			container[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 1;
		
		for(int i=1; i<length; i++) {
			if(container[i-1] > container[i]) {
				count++;
			}
		} 
		
		System.out.println(count);

	}

}
