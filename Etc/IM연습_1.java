package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class IM연습_1 {

	static int testCase;
	static int lightCount;
	static boolean[] lights;
	static boolean[] answer;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			
			lightCount = Integer.parseInt(br.readLine()) + 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			lights = new boolean[lightCount];
			answer = new boolean[lightCount];
			int count = 0;
			
			for(int i=1; i<lightCount; i++) {
				int input = Integer.parseInt(st.nextToken());
				if(input > 0) {
					answer[i] = true;
				}
			}
			
			for(int i=1; i<lightCount; i++) {
				if(answer[i] != lights[i]) {
					count++;
					for(int j=1; j<lightCount; j++) {
						if(j % i == 0) {
							lights[j] = !lights[j];
						}
					}
				}
			}
			
			for(int i=0; i<lightCount; i++) {
				if(lights[i] != answer[i]) {
					count = -1;
					break;
				}
			}
			
			result.append("#" + t + " " + count + "\n");
		}
		System.out.println(result);
	}

}
