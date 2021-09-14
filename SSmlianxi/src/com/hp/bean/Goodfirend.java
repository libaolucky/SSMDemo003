package com.hp.bean;

public class Goodfirend {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Goodfirend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
