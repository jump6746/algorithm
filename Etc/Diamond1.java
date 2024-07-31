package algol0729;

import java.util.Scanner;

public class Diamond1 {

	static int n;
	
	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		n = scann.nextInt();
		starDiamond(n);

	}
	
	static void starDiamond(int n) {
		for(int i=0; i<n; i++) {
			if(i==0 || i==n-1) {
				for(int j=0; j<n; j++) {
					System.out.print("*");
				}
			}else {
				for(int j=0; j<Math.abs(i-n/2)+1; j++) {
					System.out.print("*");
				}
				for(int j=0; j<n-2*(Math.abs(i-n/2)+1); j++) {
					System.out.print(" ");
				}
				for(int j=0; j<Math.abs(i-n/2)+1; j++) {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
	}

}
