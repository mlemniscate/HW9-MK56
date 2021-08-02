package ir.maktab.java_third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(){{
           add(new Person("Milad", "Abdi"));
           add(new Person("Armin", "Bargi"));
           add(new Person("Amin", "Tavakkoli"));
           add(new Person("Alireza", "Dadkhah"));
           add(new Person("Yousef", "Taherolgalb"));
        }};

        Collections.sort(persons);

        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
