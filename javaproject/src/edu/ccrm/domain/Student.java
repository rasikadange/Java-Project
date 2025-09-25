package ccrm.domain;
import java.util.*;

public class Student extends Person {
    private String regNo;
    private boolean active;
    private List<String> enrolledCourses;
    public Student(String id, String name, String email, String regNo) {
        super(id, name, email);
        this.regNo = regNo;
        this.active = true;
        this.enrolledCourses = new ArrayList<>();
    }
    public String getRegNo() { return regNo; }
    public boolean isActive() { return active; }
    public void deactivate() { active = false; }
    public List<String> getEnrolledCourses() { return enrolledCourses; }
    public String getProfile() {
        return String.format("Student: %s (%s)", fullName, regNo);
    }
}
