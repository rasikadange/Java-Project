package ccrm.domain;
public class Course {
    private String code;
    private String title;
    private int credits;
    private String instructorId;
    private String department;
    private Semester semester;
    public Course(String code, String title, int credits, String instructorId, String dept, Semester sem) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.instructorId = instructorId;
        this.department = dept;
        this.semester = sem;
    }
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public String getInstructorId() { return instructorId; }
    public String getDepartment() { return department; }
    public Semester getSemester() { return semester; }
    public String toString() {
        return String.format("%s - %s (%d credits, %s, %s)", code, title, credits, department, semester);
    }
}
