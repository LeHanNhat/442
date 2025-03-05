package lab1q4;

public class Fibonacci {
	public int fib(int n) {
		switch (n) {
			case 0: return 0;
			case 1: return 1;
//			default: return (fib(n - 1) + fib(n - 2)) + 1 ;
			//fixed
			default: return (fib(n - 1) + fib(n - 2))  ;
		}
	}
}
