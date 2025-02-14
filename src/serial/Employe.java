package serial;

import java.io.Serializable;
import java.time.LocalDate;

public class Employe implements Serializable {

    private long id;
    private String name;
    private transient int salary;
    private LocalDate date;

    private static final int AGE = 5;

    public Employe() {

    }

    public Employe(long id, String name, int salary, LocalDate date) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", date=" + date +
                ", age=" + AGE +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
