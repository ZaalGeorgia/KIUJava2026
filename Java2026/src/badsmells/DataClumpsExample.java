package badsmells;

/*
 * Smell: Data Clumps
 *
 * The same related data appears in repeated groups. The problem is not just one
 * long parameter list; it is that the code keeps carrying the same cluster of
 * values around as separate variables instead of modeling them as one concept.
 *
 * Proposed Refactorings:
 * - Introduce a ContactInfo class for name, email, and phone.
 * - Move related behavior onto that new object.
 */
public class DataClumpsExample {

	public String buildLabel(String name, String email, String phone) {
		return name + " <" + email + ">, phone: " + phone;
	}

	public String buildEmailGreeting(String name, String email, String phone) {
		return "To: " + email + ", hello " + name;
	}

	public String buildSmsMessage(String name, String email, String phone) {
		return "SMS to " + phone + ": Hi " + name;
	}

	public boolean isReachable(String name, String email, String phone) {
		return email != null && !email.trim().isEmpty() && phone != null && !phone.trim().isEmpty();
	}

	public void clientCode() {
		String studentName = "Nino";
		String studentEmail = "nino@example.com";
		String studentPhone = "+995-555-000-001";

		String advisorName = "Giorgi";
		String advisorEmail = "giorgi@example.com";
		String advisorPhone = "+995-555-000-002";

		String accountantName = "Maka";
		String accountantEmail = "maka@example.com";
		String accountantPhone = "+995-555-000-003";

		// The same clump is reused across different operations for each peer.
		String studentLabel = buildLabel(studentName, studentEmail, studentPhone);
		String studentGreeting = buildEmailGreeting(studentName, studentEmail, studentPhone);
		String studentSms = buildSmsMessage(studentName, studentEmail, studentPhone);
		boolean studentReachable = isReachable(studentName, studentEmail, studentPhone);

		String advisorLabel = buildLabel(advisorName, advisorEmail, advisorPhone);
		String advisorGreeting = buildEmailGreeting(advisorName, advisorEmail, advisorPhone);
		String advisorSms = buildSmsMessage(advisorName, advisorEmail, advisorPhone);
		boolean advisorReachable = isReachable(advisorName, advisorEmail, advisorPhone);

		String accountantLabel = buildLabel(accountantName, accountantEmail, accountantPhone);
		String accountantGreeting = buildEmailGreeting(accountantName, accountantEmail, accountantPhone);
		String accountantSms = buildSmsMessage(accountantName, accountantEmail, accountantPhone);
		boolean accountantReachable = isReachable(accountantName, accountantEmail, accountantPhone);

		System.out.println(studentLabel);
		System.out.println(studentGreeting);
		System.out.println(studentSms);
		System.out.println(studentReachable);

		System.out.println(advisorLabel);
		System.out.println(advisorGreeting);
		System.out.println(advisorSms);
		System.out.println(advisorReachable);

		System.out.println(accountantLabel);
		System.out.println(accountantGreeting);
		System.out.println(accountantSms);
		System.out.println(accountantReachable);
	}
}
