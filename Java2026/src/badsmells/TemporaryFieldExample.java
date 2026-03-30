package badsmells;

/*
 * Smell: Temporary Field
 *
 * The object has fields that matter only in certain modes. Depending on which
 * method was called, part of the object's state is irrelevant.
 *
 * Proposed Refactorings:
 * - Extract classes for the different modes.
 * - Move mode-specific fields and logic into the appropriate class.
 */
public class TemporaryFieldExample {

	private String examRoom;
	private String onlineMeetingLink;

	public String prepareOnsiteExam(boolean onsite) {
		if (onsite) {
			examRoom = "B-204";
			return "Use room " + examRoom;
		}
		return "No room needed";
	}

	public String prepareOnlineExam(boolean online) {
		if (online) {
			onlineMeetingLink = "https://meet.example/exam";
			return "Join " + onlineMeetingLink;
		}
		return "No meeting needed";
	}

	public void clientCode() {
		System.out.println(prepareOnsiteExam(true));
		System.out.println(prepareOnlineExam(true));
		System.out.println("room=" + examRoom + ", link=" + onlineMeetingLink);
	}
}
