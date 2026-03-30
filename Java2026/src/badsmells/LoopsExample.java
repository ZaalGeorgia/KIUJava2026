package badsmells;

import java.util.ArrayList;
import java.util.List;

/*
 * Smell: Loops
 *
 * The loop hides a simple collection transformation: filter students by GPA and
 * collect their names. Fowler treats this as a smell when a clearer pipeline
 * form is available.
 *
 * Proposed Refactorings:
 * - Replace the loop with a stream pipeline.
 * - Extract the selection predicate into a named method if it is reused.
 */
public class LoopsExample {

	public List<String> honorStudents(List<Student> students) {
		List<String> result = new ArrayList<>();
		for (Student student : students) {
			if (student.gpa > 3.5) {
				result.add(student.name);
			}
		}
		return result;
	}

	static class Student {

		String name;
		double gpa;

		Student(String name, double gpa) {
			this.name = name;
			this.gpa = gpa;
		}
	}

	public void clientCode() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Nino", 3.9));
		students.add(new Student("Giorgi", 3.1));
		students.add(new Student("Maka", 3.7));

		System.out.println(honorStudents(students));
	}
}
