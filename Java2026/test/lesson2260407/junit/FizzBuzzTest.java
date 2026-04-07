package lesson2260407.junit;

import static org.junit.Assert.*;

import org.junit.Test;


public class FizzBuzzTest {

	FizzBuzz fizzBuzz = new FizzBuzz();

	@Test
	public void testResultisNotNull() {
		assertNotNull(fizzBuzz.evaluate(3));
	}

	@Test
	public void test3() {
		assertEquals("Fizz", fizzBuzz.evaluate(3));
	}
	
	@Test
	public void test5() {
		assertEquals("Buzz", fizzBuzz.evaluate(5));
	}

	@Test
	public void test1() {
		assertEquals("1", fizzBuzz.evaluate(1));
	}

	@Test
	public void test10() {
		assertEquals("Buzz", fizzBuzz.evaluate(10));
	}

	@Test
	public void test9() {
		assertEquals("Fizz", fizzBuzz.evaluate(9));
	}

	@Test
	public void test15() {
		assertEquals("FizzBuzz", fizzBuzz.evaluate(15));
	}

}
