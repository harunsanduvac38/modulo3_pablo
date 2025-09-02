package recursividad;

public class R02Fibonacci {

	public static int fibonacci(int n) {
		if (n <= 1)
			return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static int fibonacci2(int n) {
		return switch(n) {
			case 0 -> 0;
			case 1 -> 1;
			default -> fibonacci(n-1) + fibonacci(n-2);
		};				
	}
	
	
}
