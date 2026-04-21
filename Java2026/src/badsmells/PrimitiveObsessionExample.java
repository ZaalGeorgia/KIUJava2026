package badsmells;

/*
 * Smell:
 * Age, status, unpaid balance, and country are represented as raw primitives
 * and strings instead of domain concepts. This hides meaning, spreads business
 * rules into one boolean expression, and relies on magic values.
 *
 * Refactorings:
 * - Replaced status and country code strings with enums
 * - Introduced a StudentProfile domain object
 * - Moved the dorm room eligibility rule into that object
 *
 * Why better:
 * The code now expresses domain meaning more clearly, avoids magic strings,
 * and keeps the business rule close to the data it uses.
 *
 * Behavior:
 * The observable behavior remains unchanged.
 */
public class PrimitiveObsessionExample {

    enum StudentStatus {
        ACTIVE,
        BLOCKED
    }

    enum Country {
        GE,
        US
    }

    static class StudentProfile {
        private final int age;
        private final StudentStatus status;
        private final double unpaidBalance;
        private final Country country;

        StudentProfile(int age, StudentStatus status, double unpaidBalance, Country country) {
            this.age = age;
            this.status = status;
            this.unpaidBalance = unpaidBalance;
            this.country = country;
        }

        public boolean canRentDormRoom() {
            return age >= 18
                    && status == StudentStatus.ACTIVE
                    && unpaidBalance < 100
                    && country == Country.GE;
        }
    }

    public boolean canRentDormRoom(StudentProfile studentProfile) {
        return studentProfile.canRentDormRoom();
    }

    public void clientCode() {
        StudentProfile eligibleStudent = new StudentProfile(19, StudentStatus.ACTIVE, 0.0, Country.GE);
        StudentProfile ineligibleStudent = new StudentProfile(17, StudentStatus.BLOCKED, 120.0, Country.US);

        System.out.println(canRentDormRoom(eligibleStudent));
        System.out.println(canRentDormRoom(ineligibleStudent));
    }
}
