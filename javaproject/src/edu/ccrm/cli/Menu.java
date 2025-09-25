package ccrm.cli;
import ccrm.service.*;
import ccrm.domain.*;
import java.util.*;

public class Menu {
    private StudentService studentService = new StudentService();
    private CourseService courseService = new CourseService();
    private EnrollmentService enrollmentService = new EnrollmentService();
    private TranscriptService transcriptService = new TranscriptService(enrollmentService, courseService);

    public void show() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====== CCRM Menu ======");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Courses");
            System.out.println("3. Enrollment/Grades");
            System.out.println("4. Print Transcript");
            System.out.println("0. Exit");
            switch (sc.nextInt()) {
                case 1: manageStudents(sc); break;
                case 2: manageCourses(sc); break;
                case 3: enrollMenu(sc); break;
                case 4:
                    System.out.print("Enter student id: ");
                    String sid = sc.next();
                    transcriptService.printTranscript(sid);
                    break;
                case 0: System.exit(0);
                default: continue;
            }
        }
    }

    private void manageStudents(Scanner sc) {
        System.out.println("1. Add Student");
        System.out.println("2. List Students");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("Id: "); String id = sc.next();
            System.out.print("Name: "); String name = sc.next();
            System.out.print("Email: "); String email = sc.next();
            System.out.print("RegNo: "); String regNo = sc.next();
            studentService.addStudent(new Student(id, name, email, regNo));
        } else if (choice == 2) {
            List<Student> l = studentService.listStudents();
            l.forEach(s -> System.out.println(s.getProfile()));
        }
    }

    private void manageCourses(Scanner sc) {
        System.out.println("1. Add Course");
        System.out.println("2. List Courses");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("Code: "); String code = sc.next();
            System.out.print("Title: "); String title = sc.next();
            System.out.print("Credits: "); int credits = sc.nextInt();
            System.out.print("Instructor id: "); String instId = sc.next();
            System.out.print("Department: "); String dept = sc.next();
            System.out.print("Semester (SPRING/SUMMER/FALL): ");
            Semester sem = Semester.valueOf(sc.next());
            courseService.addCourse(new Course(code, title, credits, instId, dept, sem));
        } else if (choice == 2) {
            List<Course> l = courseService.listCourses();
            l.forEach(System.out::println);
        }
    }

    private void enrollMenu(Scanner sc) {
        System.out.println("1. Enroll");
        System.out.println("2. Assign Grade");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("Student id: "); String sid = sc.next();
            System.out.print("Course code: "); String code = sc.next();
            enrollmentService.enroll(sid, code);
        } else if (choice == 2) {
            System.out.print("Student id: "); String sid = sc.next();
            System.out.print("Course code: "); String code = sc.next();
            System.out.print("Grade (S/A/B/C/D/E/F): ");
            Grade grade = Grade.valueOf(sc.next());
            enrollmentService.assignGrade(sid, code, grade);
        }
    }
}
