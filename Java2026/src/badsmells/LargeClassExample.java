package badsmells;

import java.util.ArrayList;
import java.util.List;

/*
 * Smell: Large Class
 *
 * This class mixes enrollment, staffing, finance, cafeteria, transport, help
 * desk, payroll, and website concerns. Too many responsibilities are being kept
 * in one abstraction.
 *
 * Proposed Refactorings:
 * - Extract cohesive subsets into separate classes.
 * - Split responsibilities by domain area and move related fields with behavior.
 */
public class LargeClassExample {

	private String schoolName;
	private String address;
	private final List<String> students = new ArrayList<>();
	private final List<String> teachers = new ArrayList<>();
	private final List<String> courses = new ArrayList<>();
	private double budget;
	private int openTickets;
	private String cafeteriaMenu;
	private String busSchedule;
	private String websiteTheme;
	private String payrollDay;

	public void enrollStudent(String student) {
		students.add(student);
	}

	public void hireTeacher(String teacher) {
		teachers.add(teacher);
	}

	public void addCourse(String course) {
		courses.add(course);
	}

	public void chargeTuition(double amount) {
		budget += amount;
	}

	public void paySalary(double amount) {
		budget -= amount;
	}

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

	public void setPayrollDay(String day) {
		payrollDay = day;
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
