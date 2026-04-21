package badsmells;

/*
 * Smell:
 * The client navigates through a chain of objects to get one value, which
 * creates unnecessary coupling to the internal object graph.
 *
 * Refactorings:
 * - Hid the delegate chain behind a simpler method in University
 * - Reduced knowledge of internal structure in client code
 *
 * Why better:
 * The client now depends only on University, not on the full path through
 * Department, Coordinator, and Office. This makes the code easier to maintain.
 *
 * Behavior:
 * The observable behavior remains unchanged.
 */
public class MessageChainsExample {

    static class University {

        Department getDepartment() {
            return new Department();
        }

        String getCoordinatorPhoneNumber() {
            return getDepartment().getCoordinator().getOffice().getPhoneNumber();
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
        System.out.println(university.getCoordinatorPhoneNumber());
    }
}
