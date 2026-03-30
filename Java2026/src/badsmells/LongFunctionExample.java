package badsmells;

/*
 * Smell: Long Function
 *
 * One function handles discount calculation, shipping, tax, approval logic, and
 * output formatting. Several distinct tasks are mixed into one block.
 *
 * Proposed Refactorings:
 * - Extract methods for discount, shipping, tax, and approval logic.
 * - Introduce parameter object or helper class if data starts traveling together.
 */
public class LongFunctionExample {

	public String processOrder(String customerType, int quantity, double price, boolean expressDelivery) {
		double subtotal = quantity * price;
		double discount = 0;
		if ("STUDENT".equals(customerType)) {
			discount = subtotal * 0.05;
		} else if ("VIP".equals(customerType)) {
			discount = subtotal * 0.12;
		} else if ("EMPLOYEE".equals(customerType)) {
			discount = subtotal * 0.20;
		}

		double shipping;
		if (expressDelivery) {
			shipping = 25;
			if (quantity > 10) {
				shipping += 10;
			}
		} else {
			shipping = 10;
			if (quantity > 10) {
				shipping += 5;
			}
		}

		double tax = (subtotal - discount) * 0.18;
		double total = subtotal - discount + shipping + tax;

		String status;
		if (total > 500) {
			status = "MANAGER_APPROVAL";
		} else if (total > 200) {
			status = "FINANCE_REVIEW";
		} else {
			status = "AUTO_APPROVED";
		}

		StringBuilder summary = new StringBuilder();
		summary.append("customerType=").append(customerType).append('\n');
		summary.append("quantity=").append(quantity).append('\n');
		summary.append("price=").append(price).append('\n');
		summary.append("subtotal=").append(subtotal).append('\n');
		summary.append("discount=").append(discount).append('\n');
		summary.append("shipping=").append(shipping).append('\n');
		summary.append("tax=").append(tax).append('\n');
		summary.append("total=").append(total).append('\n');
		summary.append("status=").append(status);
		return summary.toString();
	}

	public void clientCode() {
		System.out.println(processOrder("VIP", 12, 30, true));
		System.out.println(processOrder("STUDENT", 2, 50, false));
	}
}
