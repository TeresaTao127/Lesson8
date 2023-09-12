package lesson8task1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class Names {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Catherine");
        names.add("Timon");
        names.add("Ted");
        names.add("Anna");
        names.add("Caroline");
        names.add("Dorothy");
        names.add("Peter");


        Set<String> uniqueNames = new LinkedHashSet<>();
        // Iterate through the list and add elements to the set
        for (String name : names) {
            uniqueNames.add(name);
        }


        // Convert the Set to a List
        List<String> namesWithoutDuplicates = new ArrayList<>(uniqueNames);

        // Print the list without duplicates
        for (String name : namesWithoutDuplicates) {
            System.out.println(name);
        }
        System.out.println("-------------");


        // Iterate through the list in reverse order and print each item
        for (int i = names.size() - 1; i >= 0; i--) {
            String reverseNames = names.get(i);
            System.out.println(reverseNames);
        }
        System.out.println("-------------");


        // Replace all occurrences of "Anna" with "Joanna"
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals("Anna")) {
                names.set(i, "Joanna");
            }
        }

        // Display the modified list
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("-------------");
    }
}



