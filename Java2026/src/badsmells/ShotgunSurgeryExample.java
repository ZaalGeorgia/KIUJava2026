package badsmells;

/*
 * Smell: Shotgun Surgery
 *
 * A single concept, course title wording, is spread across several classes. One
 * naming change would trigger several small edits in different places.
 *
 * Proposed Refactorings:
 * - Move shared formatting behavior into one class.
 * - Introduce a single source of truth for course presentation rules.
 */
public class ShotgunSurgeryExample {

	static class Course {

		private final String title;

		Course(String title) {
			this.title = title;
		}

		public String label() {
			return "Course: " + title;
		}
	}

	static class Invoice {

		private final String courseTitle;

		Invoice(String courseTitle) {
			this.courseTitle = courseTitle;
		}

		public String description() {
			return "Invoice for " + courseTitle;
		}
	}

	static class Certificate {

		private final String courseTitle;

		Certificate(String courseTitle) {
			this.courseTitle = courseTitle;
		}

		public String text() {
			return "Completed " + courseTitle;
		}
	}

	public void clientCode() {
		Course course = new Course("Refactoring");
		Invoice invoice = new Invoice("Refactoring");
		Certificate certificate = new Certificate("Refactoring");

		System.out.println(course.label());
		System.out.println(invoice.description());
		System.out.println(certificate.text());
	}
}
