package badsmells;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Smell:
 * The internal list of enrolled students is returned directly, allowing external
 * code to modify the internal state without control.
 *
 * Refactorings:
 * - Returned an unmodifiable view of the list
 * - Ensured all modifications happen through controlled methods
 *
 * Why better:
 * The internal state is now protected. External code cannot accidentally or
 * intentionally modify the list, which improves encapsulation and safety.
 *
 * Behavior:
 * The observable behavior remains unchanged.
 */
public class MutableDataExample {

    private final List<String> enrolledStudents = new ArrayList<>();

    public List<String> getEnrolledStudents() {
        return Collections.unmodifiableList(enrolledStudents);
    }

    public void enroll(String studentId) {
        enrolledStudents.add(studentId);
    }

    public void clientCode() {
        enroll("s-1001");
        List<String> students = getEnrolledStudents();

        // students.clear(); // This would now throw UnsupportedOperationException

        System.out.println(getEnrolledStudents().size());
    }
}
