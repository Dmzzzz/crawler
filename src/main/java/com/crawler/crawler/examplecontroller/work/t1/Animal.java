package com.crawler.crawler.examplecontroller.work.t1;

import java.util.List;

public class Animal {

    private final String name;
    private final int age;

    private final List<Dog> dogList;

    public Animal(String name, int age, List<Dog> dogList) {
        this.name = name;
        this.age = age;
        this.dogList = dogList;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Dog> getDogList() {
        return dogList;
    }
}
