package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Swea_1974 {
	
	static int testCase;
	static int[][] map = new int[9][9];
	static Set<Integer> row;
	static Set<Integer> col;
	static Set<Integer> square;
	static int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	static int[] y = {1, 4, 7, 1, 4, 7, 1, 4, 7};
	static int[] x = {1, 1, 1, 4, 4, 4, 7, 7, 7};
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st;
			for(int i=0; i<9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean sdokuValid = true;
			for(int i=0; i<9; i++) {
				row = new HashSet<>();
				col = new HashSet<>();
				square = new HashSet<>();
				
				for(int j=0; j<9; j++) {
					row.add(map[i][j]);
					col.add(map[j][i]);
					square.add(map[y[i] + dr[j]][x[i] + dc[j]]);
				}
				
				if(row.size() + col.size() + square.size() < 27) {
					sdokuValid = false;
				}
			}
			
			result.append("#"+(t+1)+" ");
			if(sdokuValid) {
				result.append("1\n");
			}else {
				result.append("0\n");
			}
			
		}
		
		System.out.println(result);
	}
}
