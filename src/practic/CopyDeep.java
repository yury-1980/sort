package practic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CopyDeep {
    public static void main(String[] args) {

        List<Person> personOrigin = new ArrayList<>();
        personOrigin.add(new Person("Vase"));

        List<Person> person1 = new ArrayList<>();
        person1.add(new Person("1245"));
        Collections.copy(person1, personOrigin);
//        personOrigin.set(0, new Person("Pete"));
        personOrigin.get(0).setName("Pete");
//        person1.add(personOrigin.get(0));
        Person person = new Person("lm");

        System.out.println("personOrigin = " + personOrigin);
        System.out.println("person1 = " + person1);

        Object object = new Person("");



    }

}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // Конструктор копирования
    public Person(Person other) {
        this.name = other.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}
