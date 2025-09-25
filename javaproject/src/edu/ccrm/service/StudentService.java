package ccrm.service;
import ccrm.domain.Student;
import java.util.*;

public class StudentService {
    private Map<String, Student> students = new HashMap<>();
    public void addStudent(Student s) { students.put(s.getId(), s); }
    public Student getStudent(String id) { return students.get(id); }
    public List<Student> listStudents() { return new ArrayList<>(students.values()); }
    public void deactivateStudent(String id) {
        Student s = students.get(id);
        if (s != null) s.deactivate();
    }
}
