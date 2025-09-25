package ccrm.domain;
public class Instructor extends Person {
    private String department;
    public Instructor(String id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
    }
    public String getDepartment() { return department; }
    public String getProfile() {
        return String.format("Instructor: %s (%s)", fullName, department);
    }
}
