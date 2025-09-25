package ccrm.service;
import ccrm.domain.*;

import java.util.List;

public class TranscriptService {
    private EnrollmentService enrollmentService;
    private CourseService courseService;
    public TranscriptService(EnrollmentService es, CourseService cs) {
        this.enrollmentService = es;
        this.courseService = cs;
    }
    public void printTranscript(String studentId) {
        List<Enrollment> list = enrollmentService.getEnrollmentsForStudent(studentId);
        double totalPoints = 0;
        int totalCredits = 0;
        System.out.println("Transcript for Student: " + studentId);
        for (Enrollment e : list) {
            Course c = courseService.getCourse(e.getCourseCode());
            Grade g = e.getGrade();
            int pts = (g != null) ? g.getPoints() : 0;
            int credits = (c != null) ? c.getCredits() : 0;
            totalPoints += pts * credits;
            totalCredits += credits;
            System.out.printf("Course: %s  | Credits: %d  | Grade: %s\n", e.getCourseCode(), credits, (g == null ? "--" : g.name()));
        }
        System.out.printf("GPA: %.2f\n", (totalCredits == 0 ? 0.0 : totalPoints/totalCredits));
    }
}
