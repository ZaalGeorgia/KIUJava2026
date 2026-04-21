package badsmells;

/*
 * Smell:
 * The same classification logic is repeated in multiple switch statements.
 * Adding a new student type requires modifying each switch, which increases
 * duplication and risk of inconsistency.
 *
 * Refactorings:
 * - Replaced string-based switches with an enum
 * - Moved behavior (discount and dorm priority) into the enum
 *
 * Why better:
 * All type-specific behavior is now centralized in one place. Adding a new
 * student type requires changing only the enum, not multiple methods.
 *
 * Behavior:
 * The observable behavior remains unchanged.
 */
public class RepeatedSwitchesExample {

    enum StudentType {
        STUDENT {
            @Override
            public double getDiscount() {
                return 0.05;
            }

            @Override
            public String getDormPriority() {
                return "NORMAL";
            }
        },
        ATHLETE {
            @Override
            public double getDiscount() {
                return 0.15;
            }

            @Override
            public String getDormPriority() {
                return "HIGH";
            }
        },
        EMPLOYEE_CHILD {
            @Override
            public double getDiscount() {
                return 0.25;
            }

            @Override
            public String getDormPriority() {
                return "LOW";
            }
        };

        public abstract double getDiscount();
        public abstract String getDormPriority();
    }

    public double tuitionDiscount(StudentType studentType) {
        return studentType.getDiscount();
    }

    public String dormPriority(StudentType studentType) {
        return studentType.getDormPriority();
    }

    public void clientCode() {
        System.out.println(tuitionDiscount(StudentType.ATHLETE));
        System.out.println(dormPriority(StudentType.ATHLETE));
    }
}
