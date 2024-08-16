package algol0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_5099 {

	static class Pizza{
		int index;
		int C;
		public Pizza(int index, int C) {
			super();
			this.index = index;
			this.C = C;
		}
	}
	
	static int T;
	static int N,M;
	static Queue<Pizza> ovens;
	static Queue<Pizza> pizzas;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			pizzas = new LinkedList<>();
			ovens = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				pizzas.offer(new Pizza(i+1, Integer.parseInt(st.nextToken())));
			}
			
			for(int i=0; i<N; i++) {
				ovens.offer(pizzas.poll());
			}
			while(ovens.size() > 1) {
				Pizza currentPizza = ovens.poll();
				currentPizza.C = currentPizza.C / 2;
				
				if(currentPizza.C > 0) {
					ovens.offer(currentPizza);
				}else if(currentPizza.C == 0) {
					if(!pizzas.isEmpty()) {
						ovens.offer(pizzas.poll());
					}
				}
			}
			
			result.append("#" + t + " " + ovens.poll().index + "\n");
		}
		System.out.println(result);
	}
}
