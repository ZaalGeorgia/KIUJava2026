package badsmells;

/*
 * Smell:
 * The class contains fields that are only used in specific scenarios (onsite or
 * online exams). This leads to partially unused object state.
 *
 * Refactorings:
 * - Removed temporary fields
 * - Kept data local within methods
 *
 * Why better:
 * The object no longer holds unnecessary state. Each method manages only the
 * data it needs, improving clarity and reducing confusion.
 *
 * Behavior:
 * The observable behavior remains unchanged.
 */
public class TemporaryFieldExample {

    public String prepareOnsiteExam(boolean onsite) {
        if (onsite) {
            String examRoom = "B-204";
            return "Use room " + examRoom;
        }
        return "No room needed";
    }

    public String prepareOnlineExam(boolean online) {
        if (online) {
            String onlineMeetingLink = "https://meet.example/exam";
            return "Join " + onlineMeetingLink;
        }
        return "No meeting needed";
    }

    public void clientCode() {
        System.out.println(prepareOnsiteExam(true));
        System.out.println(prepareOnlineExam(true));
        System.out.println("room=B-204, link=https://meet.example/exam");
    }
}
