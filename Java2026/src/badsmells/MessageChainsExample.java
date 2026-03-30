package badsmells;

/*
 * Smell: Message Chains
 *
 * The caller navigates through several objects to get one value. That couples
 * the caller to the full object graph instead of to a simpler abstraction.
 *
 * Proposed Refactorings:
 * - Hide delegates behind a simpler method.
 * - Move the behavior closer to the object that owns the needed data.
 */
public class MessageChainsExample {

	static class University {

		Department getDepartment() {
			return new Department();
		}
	}

	static class Department {

		Coordinator getCoordinator() {
			return new Coordinator();
		}
	}

	static class Coordinator {

		Office getOffice() {
			return new Office();
		}
	}

	static class Office {

		String getPhoneNumber() {
			return "555-0101";
		}
	}

	public void clientCode() {
		University university = new University();
		System.out.println(university.getDepartment().getCoordinator().getOffice().getPhoneNumber());
	}
}
