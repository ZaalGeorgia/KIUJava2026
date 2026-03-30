package badsmells;

/*
 * Smell: Global Data
 *
 * These public static fields are reachable from anywhere. That makes ownership
 * weak and makes changes harder to track.
 *
 * Proposed Refactorings:
 * - Encapsulate the global variables behind methods.
 * - Move the state into a dedicated object with controlled access.
 */
public class GlobalDataExample {

	public static String currentSemester = "SPRING";
	public static double tuitionRate = 1250.0;

	public static void applyEmergencyIncrease(double delta) {
		tuitionRate += delta;
	}

	static class BillingService {
		public double calculateInvoice(int credits) {
			return credits * GlobalDataExample.tuitionRate;
		}
	}

	static class SemesterAdministration {
		public void openFallSemester() {
			GlobalDataExample.currentSemester = "FALL";
		}

		public void approveRateIncrease() {
			GlobalDataExample.tuitionRate = GlobalDataExample.tuitionRate + 100;
		}
	}

	public void clientCode() {
		BillingService billingService = new BillingService();
		SemesterAdministration administration = new SemesterAdministration();

		System.out.println(currentSemester);
		System.out.println(billingService.calculateInvoice(3));
		administration.openFallSemester();
		administration.approveRateIncrease();
		System.out.println(currentSemester);
		System.out.println(billingService.calculateInvoice(3));
	}
}
