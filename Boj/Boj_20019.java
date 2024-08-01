package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Boj_20019 {
	static int testCase;
	static char[] word;
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			
			word = br.readLine().toCharArray();
			int length = word.length;
			boolean palindromeValid = palindrome(word, length);
			if(palindromeValid) {
				palindromeValid = palindrome(word, length/2);
			}
			
			if(palindromeValid) {
				result.append("#"+(t+1)+" YES\n");
			}else {
				result.append("#"+(t+1)+" NO\n");
			}
			
		}
		
		System.out.println(result);
	}
	
	private static boolean palindrome(char[] word, int length) {
		boolean result = true;
		
		for(int i=0; i<length/2; i++) {
			if(word[i] != word[length-i-1]) {
				result = false;
			}
		}
		
		return result;
	}

}
