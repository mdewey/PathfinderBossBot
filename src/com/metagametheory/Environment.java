package com.metagametheory;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Environment {

    private UUID id = UUID.randomUUID();

    public Cares caresAboutSelf;
    public Cares hasLowHealth;

    private static Cares SeedRandomBoolean() {
        var rand = new Random();
        var next = rand.nextInt(3);

        return switch (next) {
            case 0 -> Cares.NO;
            case 1 -> Cares.WILDCARD;
            case 2 -> Cares.YES;
            default -> null;
        };
    }

    private static boolean CompareProperties(Cares x, Cares y) {
        if (x == Cares.WILDCARD || y == Cares.WILDCARD) {
            return true;
        } else {
            return x == y;
        }
    }

    public boolean DoesMatch(Environment outside) {
        var matches = new ArrayList<Boolean>();
        matches.add(CompareProperties(outside.caresAboutSelf, this.caresAboutSelf));
        matches.add(CompareProperties(outside.hasLowHealth, this.hasLowHealth));
        return matches.stream().allMatch(m -> m);
    }

    public Environment() {
        this.caresAboutSelf = SeedRandomBoolean();
        this.hasLowHealth = SeedRandomBoolean();
    }

    @Override
    public String toString() {
        return "Environment{" +
                "caresAboutSelf=" + caresAboutSelf +
                ", hasLowHealth=" + hasLowHealth +
                '}';
    }
}
