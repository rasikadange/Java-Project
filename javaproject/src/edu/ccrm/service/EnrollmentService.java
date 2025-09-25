package ccrm.service;
import ccrm.domain.*;
import java.util.*;

public class EnrollmentService {
    private List<Enrollment> enrollments = new ArrayList<>();
    public void enroll(String studentId, String courseCode) {
        enrollments.add(new Enrollment(studentId, courseCode));
    }
    public List<Enrollment> getEnrollmentsForStudent(String studentId) {
        List<Enrollment> l = new ArrayList<>();
        for (Enrollment e : enrollments)
            if (e.getStudentId().equals(studentId)) l.add(e);
        return l;
    }
    public void assignGrade(String studentId, String courseCode, Grade grade) {
        for (Enrollment e : enrollments) {
            if (e.getStudentId().equals(studentId) && e.getCourseCode().equals(courseCode)) {
                e.setGrade(grade);
                break;
            }
        }
    }
}
