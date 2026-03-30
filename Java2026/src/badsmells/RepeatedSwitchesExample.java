package badsmells;

/*
 * Smell: Repeated Switches
 *
 * The same classification logic appears in multiple switch statements. Adding a
 * new student type requires coordinated edits in each one.
 *
 * Proposed Refactorings:
 * - Replace the switches with polymorphism.
 * - Or centralize the classification in one enum or helper so new cases are
 *   added in one place instead of in many repeated switches.
 */
public class RepeatedSwitchesExample {

	public double tuitionDiscount(String studentType) {
		switch (studentType) {
		case "STUDENT":
			return 0.05;
		case "ATHLETE":
			return 0.15;
		case "EMPLOYEE_CHILD":
			return 0.25;
		default:
			return 0;
		}
	}

	public String dormPriority(String studentType) {
		switch (studentType) {
		case "STUDENT":
			return "NORMAL";
		case "ATHLETE":
			return "HIGH";
		case "EMPLOYEE_CHILD":
			return "LOW";
		default:
			return "UNKNOWN";
		}
	}

	public void clientCode() {
		System.out.println(tuitionDiscount("ATHLETE"));
		System.out.println(dormPriority("ATHLETE"));
	}
}
