package badsmells;

/*
 * Smell: Comments
 *
 * The issue is not that comments exist. The issue is that the comments are
 * compensating for code that should explain itself better through structure and
 * naming.
 *
 * Proposed Refactorings:
 * - Extract intention-revealing methods.
 * - Rename variables and methods so the code explains itself.
 */
public class CommentsExample {

	public double finalPrice(double basePrice, boolean vip, int quantity) {
		// If the customer is VIP, give them the better discount.
		// If they bought a lot, give them another discount.
		// Add tax at the end because that is how the business works.
		double result = basePrice;
		if (vip) {
			result = result - result * 0.10;
		}
		if (quantity > 20) {
			result = result - result * 0.05;
		}
		result = result + result * 0.18;
		return result;
	}

	public void clientCode() {
		double vipOrder = finalPrice(120, true, 25);
		double regularOrder = finalPrice(120, false, 5);
		System.out.println(vipOrder);
		System.out.println(regularOrder);
	}
}
