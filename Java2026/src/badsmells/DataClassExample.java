package badsmells;

/*
 * Smell: Data Class
 *
 * StudentRecord is only a bag of fields. When behavior is kept elsewhere and a
 * class mostly exposes raw data, the model stays weak and passive.
 *
 * Proposed Refactorings:
 * - Move behavior that uses the data into StudentRecord.
 * - Encapsulate fields and remove pointless setters where possible.
 */
public class DataClassExample {

	public static class StudentRecord {

		public String name;
		public int credits;
		public double gpa;
	}

	public static class HonorsEvaluator {
		public boolean isEligible(StudentRecord student) {
			return student.credits >= 30 && student.gpa >= 3.7;
		}
	}

	public static class TuitionDiscountCalculator {
		public double discountPercent(StudentRecord student) {
			if (student.gpa >= 3.8) {
				return 0.15;
			}
			if (student.gpa >= 3.5) {
				return 0.10;
			}
			return 0.0;
		}
	}

	public static class AcademicStandingReporter {
		public String describe(StudentRecord student) {
			if (student.gpa < 2.0) {
				return student.name + " is on academic probation";
			}
			if (student.credits < 15) {
				return student.name + " is a new student";
			}
			return student.name + " is in good standing";
		}
	}

	public void clientCode() {
		StudentRecord student = new StudentRecord();
		student.name = "Nino";
		student.credits = 32;
		student.gpa = 3.8;

		HonorsEvaluator honorsEvaluator = new HonorsEvaluator();
		TuitionDiscountCalculator discountCalculator = new TuitionDiscountCalculator();
		AcademicStandingReporter standingReporter = new AcademicStandingReporter();

		System.out.println(honorsEvaluator.isEligible(student));
		System.out.println(discountCalculator.discountPercent(student));
		System.out.println(standingReporter.describe(student));
	}
}
