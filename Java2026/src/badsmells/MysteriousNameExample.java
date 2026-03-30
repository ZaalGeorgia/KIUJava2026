package badsmells;

/*
 * Smell: Mysterious Name
 *
 * The names f, a, b, c, x, and y tell the reader almost nothing. Understanding
 * the code requires reverse-engineering instead of reading intention.
 *
 * Proposed Refactorings:
 * - Rename method and variables to reveal intent.
 * - Extract named helper methods if the calculation has distinct steps.
 */
public class MysteriousNameExample {

	public int f(int a, int b, int c) {
		int x = a * b;
		int y = x - c;
		return y / 2;
	}

	public void clientCode() {
		int result = f(8, 4, 6);
		System.out.println(result);
	}
}
