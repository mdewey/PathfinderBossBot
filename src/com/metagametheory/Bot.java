package com.metagametheory;

import java.util.UUID;

public class Bot {
    private UUID id = UUID.randomUUID();
    private String name;

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public Bot(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
