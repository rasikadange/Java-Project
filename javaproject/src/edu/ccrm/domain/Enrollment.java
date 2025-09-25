package ccrm.domain;
import java.time.LocalDate;

public class Enrollment {
    private String studentId;
    private String courseCode;
    private LocalDate dateEnrolled;
    private Grade grade;
    public Enrollment(String studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.dateEnrolled = LocalDate.now();
        this.grade = null;
    }
    public String getStudentId() { return studentId; }
    public String getCourseCode() { return courseCode; }
    public LocalDate getDateEnrolled() { return dateEnrolled; }
    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }
    public String toString() {
        return String.format("Enrollment [student=%s, course=%s, date=%s, grade=%s]", 
            studentId, courseCode, dateEnrolled, grade != null ? grade.name() : "N/A");
    }
}
