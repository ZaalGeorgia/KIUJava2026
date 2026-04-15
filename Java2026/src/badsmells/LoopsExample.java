package badsmells;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Smell:
 * The loop performs a simple collection transformation (filtering and mapping),
 * but expresses it in a verbose and less declarative way.
 *
 * Refactorings:
 * - Replaced the loop with a stream pipeline
 *
 * Why better:
 * The intent of the operation (filter + map + collect) is now clearer and more
 * concise, improving readability.
 *
 * Behavior:
 * The observable behavior remains unchanged.
 */
public class LoopsExample {

    public List<String> honorStudents(List<Student> students) {
        return students.stream()
                .filter(student -> student.gpa > 3.5)
                .map(student -> student.name)
                .collect(Collectors.toList());
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
