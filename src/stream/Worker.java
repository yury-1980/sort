package stream;

public class Worker {

    private String name;
    private int age;
    private int salary;
    private String position;

    public Worker(String name, int age, int salary, String position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    @Override
    public String toString() {
        return "stream.Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }
}
