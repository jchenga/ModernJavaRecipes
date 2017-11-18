package infrastructure;

import lambdas.MyFilter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Person {
    private String name;

    public Person(){};

    public Person(String name) {
        this.name = name;
    }

    //varargs constructor
    public Person(String... names) {
        System.out.println("Varargs ctor, name=" + Arrays.asList(names));
        name = Arrays.stream(names)
                .collect(Collectors.joining(" "));// concat all strings together
    }

    public Person(Person p) {
        this.name = p.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return String.format("infrastructure.Person(%s)", name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;

        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0 ;
    }
}
