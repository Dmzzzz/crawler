package com.crawler.crawler.examplecontroller.work.t1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main55 {

    public static void main(String[] args) {

        List<Dog> list = new ArrayList<Dog>() {{
           add(new Dog("1", 10));
           add(new Dog("2", 20));
           add(new Dog("3", 30));

        }};

        List<Dog> list2 = new ArrayList<Dog>() {{
            add(new Dog("5", 15));
            add(new Dog("6", 22));
            add(new Dog("7", 33));

        }};

        Animal animal = new Animal("a1", 55,  list);
        Animal animal2 = new Animal("a2", 100, list2);

        List<Animal> animals = new ArrayList<Animal>() {{
           add(animal);
           add(animal2);
        }};


        List<Dog> collect = new ArrayList<>();
        for (Dog d : list2) {
            if (d.getAge() > 20) {
                collect.add(d);
            }
        }


    }
}

