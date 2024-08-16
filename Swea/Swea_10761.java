package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Swea_10761 {

	static int testCase;
	static int orderCount;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			
			orderCount = Integer.parseInt(st.nextToken());

			int bPosition = 1;
			int oPosition = 1;
			int bTime = 0;
			int oTime = 0;
			int totalTime = 0;
			
			for(int i=0; i<orderCount; i++) {
				String name = st.nextToken();
				int goal = Integer.parseInt(st.nextToken());
				
				if(name.equals("B")) {
					int time = Math.abs(bPosition - goal) + 1;
					bTime += time;
					if(bTime > totalTime) {
						totalTime = bTime;
					}else {
						totalTime += 1;
						bTime = totalTime;
					}
					bPosition = goal;
				}else {
					int time = Math.abs(oPosition - goal) + 1;
					oTime += time;
					if(oTime > totalTime) {
						totalTime = oTime;
					}else{
						totalTime += 1;
						oTime = totalTime;
					}
					oPosition = goal;
				}
				
//				System.out.println(" bTime : " + bTime + " oTime : " + oTime + " totalTime : " + totalTime);
			}
			
			result.append("#" + (t) + " " + totalTime + "\n");
		}
		
		System.out.println(result);
	}
}
