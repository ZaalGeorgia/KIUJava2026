package badsmells;

/*
 * Smell: Alternative Classes with Different Interfaces
 *
 * ZoomClassroom and TeamsClassroom serve a similar purpose, but their APIs do
 * not match. Because clients cannot use them through one shared protocol, code
 * must branch or adapt between them.
 *
 * Proposed Refactorings:
 * - Align the interfaces with common method names and semantics.
 * - Introduce a shared abstraction or adapter.
 */
public class AlternativeClassesWithDifferentInterfacesExample {

	static class ZoomClassroom {

		public void beginSession() {
			System.out.println("Zoom session started");
		}
	}

	static class TeamsClassroom {

		public void openMeeting() {
			System.out.println("Teams meeting started");
		}
	}

	public void clientCode() {
		ZoomClassroom zoom = new ZoomClassroom();
		TeamsClassroom teams = new TeamsClassroom();

		zoom.beginSession();
		teams.openMeeting();
	}
}
