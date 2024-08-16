package algol0729;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2309 {

	static int[] dwarfs = new int[9];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int total = 0;
		
		for(int i=0; i<9; i++) {
			dwarfs[i] = sc.nextInt();
			total += dwarfs[i];
		}
		
		total -= 100;
		
		int targetA = 0;
		int targetB = 0;
		Arrays.sort(dwarfs);
		
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(dwarfs[i] + dwarfs[j] == total) {
					targetA = i;
					targetB = j;
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			if(i == targetA || i == targetB) {
				continue;
			}
			System.out.println(dwarfs[i]);
		}
	}

}
