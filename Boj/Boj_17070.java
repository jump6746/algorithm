package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.LinkedList;

public class Boj_17070 {

	static int size;
	static int[][] map;
	static int count;
	static Stack<Integer> history;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		
		for(int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}
	
//	static void findWay() {
//		
//	}

}
