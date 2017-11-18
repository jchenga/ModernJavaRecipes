package lambdas;

import infrastructure.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructorReferencesDemo {

    private static List<String> names = Arrays.asList("Grace Hopper", "Frances Allen", "Ada Lovelace",
            "Barbara Liskov", "Adele Goldberg", "Karen Spärck Jones");

    public static void main(String[] args) {

    }

    public static List<Person> createPersonListJava7() {
        List<Person> people = new ArrayList<Person>();
        for(String name : names) {
            people.add(new Person(name));
        }
        return people;
    }

    public static List<Person> createPersonList() {
        List<Person> people = names.stream()        // Stream<String>
                .map(name -> new Person(name))      // Stream<Person>
                .collect(Collectors.toList());      // List<Person>
        return people;
    }

    public static List<Person> createPersonList_CtorRef() {
        return names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public static List<Person> createPersonList_2ArgCtrReg() {
        return names.stream()
                .map(name -> name.split(" "))
                .map(Person::new)
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public static List<Person> createPersonLinkedList() {
        return names.stream()
                .map(Person::new)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public static Person[] createPersonArray() {
        return names.stream()
                .map(Person::new)
                .toArray(Person[]::new);
    }

    public static List<Person> createPersonListUsingNew() {
        return names.stream()
                .map(Person::new)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
