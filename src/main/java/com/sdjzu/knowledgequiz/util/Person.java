package com.sdjzu.knowledgequiz.util;

import java.util.HashSet;

public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //重写hashCode方法
    public int hashCode() {
        System.out.println(this.name + ".....hashCode");
        return this.name.hashCode();
    }

    //重写equals方法
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) return false;
        Person p = (Person) obj;
        System.out.println(this.name + "..equals.." + p.name);
        return this.name.equals(p.name) ;
    }


    public static void main(String[] args) {
        HashSet<Person> hs = new HashSet();
        hs.add(new Person("zs0", 0));
        hs.add(new Person("zs1", 1));
        hs.add(new Person("zs1", 1));
        hs.add(new Person("zs1", 1));
        hs.add(new Person("zs1", 1));
        hs.add(new Person("zs1", 10));
        hs.add(new Person("zs1", 1));
        hs.add(new Person("zs2", 2));

        for (Person h : hs) {
            Person p = h;
            System.out.println(h.getName()+h.getAge());
        }

    }

}