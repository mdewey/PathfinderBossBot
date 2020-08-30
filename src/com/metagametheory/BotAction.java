package com.metagametheory;

import java.util.Random;
import java.util.UUID;

public class BotAction {
    public UUID Id = UUID.randomUUID();

    private String action;
    private int strength;
    private Environment conditions = new Environment();

    public int getStrength() {
        return strength;
    }

    public BotAction(String action) {
        this.action = action;
        this.strength = new Random().nextInt(101);
    }

    public boolean DoesMatch(Environment outside) {
        return conditions.DoesMatch(outside);
    }

    @Override
    public String toString() {
        return "Action{" +
                "Id=" + Id +
                ", action='" + action + '\'' +
                ", strength='" + strength + '\'' +
                ", conditions='" + conditions + '\'' +
                '}';
    }
}
