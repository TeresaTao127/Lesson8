package lesson8Task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PersonCollection {
    public static void main(String[] args) {

        Set<Person> peopleDefaultOrder = new TreeSet<>();
        peopleDefaultOrder.add(new Person("John", "Stone", 1997, 180.0, 76.5));
        peopleDefaultOrder.add(new Person("Alice", "Smith", 1992, 170.5, 55.4));
        peopleDefaultOrder.add(new Person("Bob", "Johnson", 2004, 184, 78.2));

        System.out.println("Default order(youngest to oldest): ");
        for (Person person : peopleDefaultOrder) {
            System.out.println(person);
        }


        List<Person> people=new ArrayList<>();
        people.add(new Person("John","Stone",1992,180.0,76.5));
        people.add(new Person("Alice","Smith",1997,170.5,55.4));
        people.add(new Person("Bob","Johnson",2004, 184, 78.2));

        Collections.sort(people, Comparator.comparingDouble(Person::getHeight));
        System.out.println("\nSorted by height(lowest to highest): ");
        for(Person person: people){
            System.out.println(person);
        }

        Collections.sort(people, Comparator.comparingDouble(Person::getWeight).reversed());
        System.out.println("\nSorted by weight(heaviest to lightest): ");
        for(Person person: people){
            System.out.println(person);
        }
    }
}
