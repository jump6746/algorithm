package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Swea_1926 {

	static int number;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		number = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=number; i++) {
			int count = 0;
			int num = i;
			while(num > 0) {
				int n = num % 10;
				if( n % 3 == 0 && n > 0) {
					count++;
				}
				
				num /= 10;
			}
			
			if(count > 0) {
				for(int j=0; j<count; j++) {
					result.append("-");
				}
			}else {
				result.append(i);
			}
			
			result.append(" ");
		}
		
		System.out.println(result);
	}

}
