package badsmells;

/*
 * Smell: Long Parameter List
 *
 * The method takes many related values directly instead of receiving a few
 * meaningful objects such as address or guardian contact information.
 *
 * Proposed Refactorings:
 * - Introduce parameter objects for address and guardian contact.
 * - Preserve whole object when the caller already has a richer object.
 */
public class LongParameterListExample {

	public String registerStudent(String firstName, String lastName, String email, String phone, String city,
			String street, String zipCode, String guardianName, String guardianPhone, String program, int startYear,
			boolean scholarship) {
		return firstName + " " + lastName + " -> " + program + " (" + startYear + "), guardian=" + guardianName
				+ ", scholarship=" + scholarship + ", address=" + city + ", " + street + ", " + zipCode + ", contact="
				+ email + "/" + phone + ", guardianPhone=" + guardianPhone;
	}

	public void clientCode() {
		String summary = registerStudent("Nino", "Beridze", "nino@example.com", "+995-555-000-001", "Tbilisi",
				"Rustaveli Ave 10", "0108", "Maka Beridze", "+995-555-000-999", "Computer Science", 2026, true);
		System.out.println(summary);
	}
}
