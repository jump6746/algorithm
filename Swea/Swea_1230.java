package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Swea_1230 {

	static int codeLength;
	static LinkedList<Integer> codes;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			codeLength = Integer.parseInt(br.readLine());
			codes = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<codeLength; i++) {
				codes.add(Integer.parseInt(st.nextToken()));
			}
			
			int commandLength = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<commandLength; i++) {
				char command = st.nextToken().toCharArray()[0];
				int x = 0;
				int y = 0;
				
				LinkedList<Integer> orders = new LinkedList<>();
				
				switch(command) {
					case 'I':
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());
						for(int j=0; j<y; j++) {
							orders.add(Integer.parseInt(st.nextToken()));
						}
						codes.addAll(x, orders);
						break;
					case 'D':
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());
						for(int j=0; j<y; j++) {
							codes.remove(x);
						}
						break;
					case 'A':
						y = Integer.parseInt(st.nextToken());
						for(int j=0; j<y; j++) {
							orders.add(Integer.parseInt(st.nextToken()));
						}
						codes.addAll(orders);
						break;
				}
				
			}
			result.append("#" + t + " ");
			for(int i=0; i<10; i++) {
				result.append(codes.get(i) + " ");
			}
			result.append("\n");
		}
		System.out.println(result);
	}

}
