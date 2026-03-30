package badsmells;

/*
 * Smell: Duplicated Code
 *
 * Both invoice methods repeat the same pricing logic. If the pricing rules
 * change, multiple copies must be found and kept in sync.
 *
 * Proposed Refactorings:
 * - Extract the shared pricing logic into one method.
 * - Move the shared behavior into a dedicated pricing class if needed.
 */
public class DuplicatedCodeExample {

	public double summerInvoice(double subtotal) {
		double tax = subtotal * 0.18;
		double shipping = subtotal > 100 ? 0 : 15;
		double discount = subtotal > 200 ? subtotal * 0.10 : 0;
		return subtotal + tax + shipping - discount;
	}

	public double winterInvoice(double subtotal) {
		double tax = subtotal * 0.18;
		double shipping = subtotal > 100 ? 0 : 15;
		double discount = subtotal > 200 ? subtotal * 0.20 : 50;
		return subtotal + tax + shipping - discount;
	}

	public void clientCode() {
		System.out.println(summerInvoice(240));
		System.out.println(winterInvoice(240));
	}
}
