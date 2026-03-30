package badsmells;

/*
 * Smell: Primitive Obsession
 *
 * Status, country, debt, and age are handled as raw primitives instead of
 * domain concepts with their own rules and meaning.
 *
 * Proposed Refactorings:
 * - Replace primitives with domain objects or enums.
 * - Move validation and business rules into those domain types.
 */
public class PrimitiveObsessionExample {

	public boolean canRentDormRoom(int age, String status, double unpaidBalance, String countryCode) {
		return age >= 18 && "ACTIVE".equals(status) && unpaidBalance < 100 && "GE".equals(countryCode);
	}

	public void clientCode() {
		System.out.println(canRentDormRoom(19, "ACTIVE", 0.0, "GE"));
		System.out.println(canRentDormRoom(17, "BLOCKED", 120.0, "US"));
	}
}
