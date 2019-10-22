package hu.elte.java.se;

import java.util.Objects;

class Person {
    private String name;
    private int salary;
    private LEVEL level;

    public Person(String name, int salary, LEVEL level) {
        this.name = name;
        this.salary = salary;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public LEVEL getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return salary == person.salary &&
                name.equals(person.name) &&
                level == person.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, level);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", level=" + level +
                '}';
    }
}
