package badsmells;

/*
 * Smell: Feature Envy
 *
 * ScholarshipCalculator mostly uses StudentAccount data and contributes little
 * of its own. The decision logic likely belongs closer to the account.
 *
 * Proposed Refactorings:
 * - Move the decision logic to StudentAccount.
 * - Extract only the truly external policy if part of the logic must stay outside.
 */
public class FeatureEnvyExample {

	static class StudentAccount {

		private final int completedCredits;
		private final double gpa;

		StudentAccount(int completedCredits, double gpa) {
			this.completedCredits = completedCredits;
			this.gpa = gpa;
		}

		public int getCompletedCredits() {
			return completedCredits;
		}

		public double getGpa() {
			return gpa;
		}
	}

	static class ScholarshipCalculator {

		public boolean qualifies(StudentAccount account) {
			return account.getCompletedCredits() >= 30 && account.getGpa() >= 3.7;
		}
	}

	public void clientCode() {
		StudentAccount account = new StudentAccount(36, 3.9);
		ScholarshipCalculator calculator = new ScholarshipCalculator();
		System.out.println(calculator.qualifies(account));
	}
}
