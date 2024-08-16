package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1873 {

	static int testCase;
	static int height;
	static int width;
	static char[][] map;
	static int commandLength;
	static char[] commands;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int direction;
	static StringBuilder result = new StringBuilder();
	
	static class Tank{
		int currentY;
		int currentX;
		
		public Tank(int currentY, int currentX) {
			this.currentY = currentY;
			this.currentX = currentX;
		}
		
		public boolean tankCommand(char C) {
			switch(C) {
				case 'U':
					direction = 0;
					if(tankSearch()) {
						tankMove(direction);
					}
					break;
				case 'D':
					direction = 2;
					if(tankSearch()) {
						tankMove(direction);				
					}
					break;
				case 'L':
					direction = 3;
					if(tankSearch()) {
						tankMove(direction);
					}
					break;
				case 'R':
					direction = 1;
					if(tankSearch()) {
						tankMove(direction);
					}
					break;
				case 'S':
					cannonShoot();
					break;
			}
			return true;
		}
		
		public boolean tankMove(int direction) {
			
			map[currentY][currentX] = '.';
			currentY += dr[direction];
			currentX += dc[direction];
			
			switch(direction) {
				case 0:
					map[currentY][currentX] = '^';
					break;
				case 1:
					map[currentY][currentX] = '>';
					break;
				case 2:
					map[currentY][currentX] = 'v';
					break;
				case 3:
					map[currentY][currentX] = '<';
					break;
			}
			
			return true;
		}
		
		public boolean tankSearch() {
			
			int newY = currentY + dr[direction];
			int newX = currentX + dc[direction];
			
			if(newY < 0 || newY == height || newX < 0 || newX == width) {
				return false;
			}else {
				// * : 벽돌, # : 강철, - : 물
				if(map[newY][newX] == '*' || map[newY][newX] == '#' || map[newY][newX] == '-') {
					return false;
				}
			}
			
			return true;
		}
		
		public boolean cannonShoot() {
			int newY = currentY + dr[direction];
			int newX = currentX + dc[direction];
			
			while(true) {
				if(newY < 0 || newY == height || newX < 0 || newX == width) {
					break;
				}else {
					if(map[newY][newX] == '*') {
						map[newY][newX] = '.';
						break;
					}else if(map[newY][newX] == '#') {
						break;
					}
				}
				
				newY += dr[direction];
				newX += dc[direction];
			}
			
			return true;
		}
		
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t=0; t<testCase; t++) {
			st = new StringTokenizer(br.readLine());
			height = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			map = new char[height][width];
			int currentY = 0;
			int currentX = 0;
			
			for(int i=0; i<height; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0; j<width; j++) {
					switch(map[i][j]) {
						case 'v':
							direction = 2;
							currentY = i;
							currentX = j;
							break;
						case '^':
							direction = 0;
							currentY = i;
							currentX = j;
							break;
						case '<':
							direction = 3;
							currentY = i;
							currentX = j;
							break;
						case '>':
							direction = 1;
							currentY = i;
							currentX = j;
							break;
					}
				}
			}
			
			commandLength = Integer.parseInt(br.readLine());
			commands = br.readLine().toCharArray();
			Tank tank = new Tank(currentY, currentX);
			
			for(int i=0; i<commands.length; i++) {
				tank.tankCommand(commands[i]);
			}
			
			result.append("#" + (t+1) + " ");
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					result.append(map[i][j]);
				}
				result.append("\n");
			}
		}
		System.out.println(result);
	}

}
