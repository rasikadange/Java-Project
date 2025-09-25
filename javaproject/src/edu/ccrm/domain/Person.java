package ccrm.domain;
import java.time.LocalDate;

public abstract class Person {
    protected String id;
    protected String fullName;
    protected String email;
    protected LocalDate dateRegistered;
    public Person(String id, String name, String email) {
        this.id = id;
        this.fullName = name;
        this.email = email;
        this.dateRegistered = LocalDate.now();
    }
    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public LocalDate getDateRegistered() { return dateRegistered; }
    public abstract String getProfile();
}
