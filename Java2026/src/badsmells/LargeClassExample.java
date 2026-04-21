package badsmells;

import java.util.ArrayList;
import java.util.List;

/*
 * Smell:
 * This class contains many unrelated responsibilities, including academics,
 * staffing, finance, support, transport, cafeteria, payroll, and website
 * management. This makes the class too large and difficult to maintain.
 *
 * Refactorings:
 * - Extracted academic responsibilities into AcademicDepartment
 * - Extracted financial responsibilities into FinanceDepartment
 * - Extracted operational responsibilities into OperationsDepartment
 *
 * Why better:
 * Responsibilities are now grouped by domain area, which improves cohesion and
 * makes changes more localized and easier to understand.
 *
 * Behavior:
 * The observable behavior remains unchanged.
 */
public class LargeClassExample {

    private String schoolName;
    private String address;

    private final AcademicDepartment academicDepartment = new AcademicDepartment();
    private final FinanceDepartment financeDepartment = new FinanceDepartment();
    private final OperationsDepartment operationsDepartment = new OperationsDepartment();

    public void enrollStudent(String student) {
        academicDepartment.enrollStudent(student);
    }

    public void hireTeacher(String teacher) {
        academicDepartment.hireTeacher(teacher);
    }

    public void addCourse(String course) {
        academicDepartment.addCourse(course);
    }

    public void chargeTuition(double amount) {
        financeDepartment.chargeTuition(amount);
    }

    public void paySalary(double amount) {
        financeDepartment.paySalary(amount);
    }

    public void openHelpDeskTicket() {
        operationsDepartment.openHelpDeskTicket();
    }

    public void updateWebsiteTheme(String theme) {
        operationsDepartment.updateWebsiteTheme(theme);
    }

    public void publishBusSchedule(String schedule) {
        operationsDepartment.publishBusSchedule(schedule);
    }

    public void publishCafeteriaMenu(String menu) {
        operationsDepartment.publishCafeteriaMenu(menu);
    }

    public void setPayrollDay(String day) {
        financeDepartment.setPayrollDay(day);
    }

    static class AcademicDepartment {
        private final List<String> students = new ArrayList<>();
        private final List<String> teachers = new ArrayList<>();
        private final List<String> courses = new ArrayList<>();

        public void enrollStudent(String student) {
            students.add(student);
        }

        public void hireTeacher(String teacher) {
            teachers.add(teacher);
        }

        public void addCourse(String course) {
            courses.add(course);
        }
    }

    static class FinanceDepartment {
        private double budget;
        private String payrollDay;

        public void chargeTuition(double amount) {
            budget += amount;
        }

        public void paySalary(double amount) {
            budget -= amount;
        }

        public void setPayrollDay(String day) {
            payrollDay = day;
        }
    }

    static class OperationsDepartment {
        private int openTickets;
        private String cafeteriaMenu;
        private String busSchedule;
        private String websiteTheme;

        public void openHelpDeskTicket() {
            openTickets++;
        }

        public void updateWebsiteTheme(String theme) {
            websiteTheme = theme;
        }

        public void publishBusSchedule(String schedule) {
            busSchedule = schedule;
        }

        public void publishCafeteriaMenu(String menu) {
            cafeteriaMenu = menu;
        }
    }

    public void clientCode() {
        enrollStudent("Nino");
        hireTeacher("Ms. Kapanadze");
        addCourse("Refactoring");
        chargeTuition(2400);
        paySalary(1200);
        openHelpDeskTicket();
        updateWebsiteTheme("blue");
        publishBusSchedule("Route A at 08:00");
        publishCafeteriaMenu("Soup and salad");
        setPayrollDay("Friday");
    }
}
