package ccrm.service;
import ccrm.domain.*;
import java.util.*;

public class CourseService {
    private Map<String, Course> courses = new HashMap<>();
    public void addCourse(Course c) { courses.put(c.getCode(), c); }
    public Course getCourse(String code) { return courses.get(code); }
    public List<Course> listCourses() { return new ArrayList<>(courses.values()); }
    public List<Course> filterByInstructor(String instructorId) {
        List<Course> l = new ArrayList<>();
        for (Course c: courses.values())
            if (c.getInstructorId().equals(instructorId)) l.add(c);
        return l;
    }
    public List<Course> filterByDepartment(String dept) {
        List<Course> l = new ArrayList<>();
        for (Course c: courses.values())
            if (c.getDepartment().equals(dept)) l.add(c);
        return l;
    }
    public List<Course> filterBySemester(Semester semester) {
        List<Course> l = new ArrayList<>();
        for (Course c: courses.values())
            if (c.getSemester() == semester) l.add(c);
        return l;
    }
}

