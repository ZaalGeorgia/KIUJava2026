package badsmells;

/*
 * Smell:
 * ZoomClassroom and TeamsClassroom provide similar behavior but expose different
 * method names, preventing them from being used through a common interface.
 *
 * Refactorings:
 * - Introduced a shared Classroom interface
 * - Unified method names across implementations
 *
 * Why better:
 * Both classes can now be used interchangeably through a common abstraction,
 * simplifying client code and improving consistency.
 *
 * Behavior:
 * The observable behavior remains unchanged.
 */
public class AlternativeClassesWithDifferentInterfacesExample {

    interface Classroom {
        void startSession();
    }

    static class ZoomClassroom implements Classroom {

        @Override
        public void startSession() {
            System.out.println("Zoom session started");
        }
    }

    static class TeamsClassroom implements Classroom {

        @Override
        public void startSession() {
            System.out.println("Teams meeting started");
        }
    }

    public void clientCode() {
        Classroom zoom = new ZoomClassroom();
        Classroom teams = new TeamsClassroom();

        zoom.startSession();
        teams.startSession();
    }
}
