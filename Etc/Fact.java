package algol0729;

public class Fact {

	public static void main(String[] args) {

		System.out.println(fact(5));
		System.out.println(sum(100));

	}
	static int sum(int n) {
		if(n == 1) return 1;
		return n + sum(n-1);
	}
	
	static int fact(int n) {
		if(n==0 || n==1) return 1;
		return n * fact(n-1);
	}

}
