//package algol0729;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
//import java.util.List;
//import java.util.ArrayList;
//
//public class Battle_1 {
//
//	static int testCase;
//	static int A;
//	static int B;
//	static int N;
//	static List<Integer> arr;
//	static StringBuilder result = new StringBuilder();
//	
//	public static void main(String[] args)throws IOException{
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		testCase = Integer.parseInt(br.readLine());
//		
//		for(int i=0; i<testCase; i++) {
//			st = new StringTokenizer(br.readLine());
//			
//			A = Integer.parseInt(st.nextToken());
//			B = Integer.parseInt(st.nextToken());
//			N = Integer.parseInt(st.nextToken());
//			arr = new ArrayList<>();
//			
//			int num = N / (A+B);
//			arr.add(1);
//			arr.add(2);
//			
//			
//			
//			
//			
//			result.append(count + "\n");
//		}
//		 
//		System.out.println(result);
//	}
//}
