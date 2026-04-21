package badsmells;

/*
 * Smell:
 * Method and variable names do not express intent. Names like f, a, b, c, x, and y
 * make the code difficult to understand without reverse-engineering.
 *
 * Refactorings:
 * - Renamed method and variables to reveal intent
 * - Introduced descriptive intermediate variables
 *
 * Why better:
 * The code is now self-explanatory and easier to read without additional comments.
 *
 * Behavior:
 * The observable behavior remains unchanged.
 */
public class MysteriousNameExample {

    public int calculateAdjustedValue(int multiplier, int baseValue, int deduction) {
        int product = multiply(multiplier, baseValue);
        int adjusted = subtract(product, deduction);
        return divideByTwo(adjusted);
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int subtract(int value, int deduction) {
        return value - deduction;
    }

    private int divideByTwo(int value) {
        return value / 2;
    }

    public void clientCode() {
        int result = calculateAdjustedValue(8, 4, 6);
        System.out.println(result);
    }
}
