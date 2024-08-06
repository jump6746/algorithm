package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Swea_new_2001 {
	
	static int testCase;
	static int mapSize;
	static int hitSize;
	static int[][] map;
	static int[][] sumMap;
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			mapSize = Integer.parseInt(st.nextToken());
			hitSize = Integer.parseInt(st.nextToken());
			map = new int[mapSize][mapSize];
			sumMap = new int[mapSize][mapSize];
			
			for(int i=0; i<mapSize; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<mapSize; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sumMap[0][0] = map[0][0];
			
			for(int i=0; i<mapSize; i++) {
				for(int j=0; j<mapSize; j++) {
					if(i > 0 && j > 0) {
						sumMap[i][j] = sumMap[i-1][j] + sumMap[i][j-1] + map[i][j] - sumMap[i-1][j-1];
					}else if(i == 0 && j > 0) {
						sumMap[i][j] = sumMap[i][j-1] + map[i][j];
					}else if(j == 0 && i > 0) {
						sumMap[i][j] = sumMap[i-1][j] + map[i][j];
					}
				}
			}
			
			int maxTotal = 0;
			for(int i=0; i<mapSize - hitSize + 1; i++) {
				for(int j=0; j<mapSize - hitSize + 1; j++) {
					int total = 0;
					int endPointX = j + hitSize - 1;
					int endPointY = i + hitSize - 1;
					if(i == 0 && j == 0) {
						total = sumMap[endPointY][endPointX];
					}else if(j == 0 && i > 0) {
						total = sumMap[endPointY][endPointX] - sumMap[i-1][endPointX];
					}else if(i == 0 && j > 0) {
						total = sumMap[endPointY][endPointX] - sumMap[endPointY][j-1];
					}else if(i > 0 && j > 0) {
						total = sumMap[endPointY][endPointX] - sumMap[i-1][endPointX] - sumMap[endPointY][j-1] + sumMap[i-1][j-1];
					}
					if(total > maxTotal) {
						maxTotal = total;
					}
				}
			}
			
			result.append("#" + (t+1) + " ");
			result.append(maxTotal + "\n");
		}
		System.out.println(result);
			
	}

}
