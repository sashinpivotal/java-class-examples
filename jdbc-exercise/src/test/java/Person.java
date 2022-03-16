import java.util.Objects;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class Main {

    public static void main(String[] args) {
        Person person1 = new Person("sang", 30);
        Person person2 = new Person("sang", 30);

        boolean b1 = (person1 == person2) ? true : false;
        boolean b2 = person1.equals(person2) ? true : false;

        System.out.println(b1);
        System.out.println(b2);
    }
}