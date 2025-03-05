package lab1q4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FibonacciTest {

	@Test
	void testFib() {
		Fibonacci fibonacci = new Fibonacci();
		assertEquals(610, fibonacci.fib(15));
	}

}
