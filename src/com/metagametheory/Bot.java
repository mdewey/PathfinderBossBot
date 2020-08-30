package com.metagametheory;

public class Bot {
    private String name;

    public String getName() {
        return name;
    }

    public Bot(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "name='" + name + '\'' +
                '}';
    }
}
