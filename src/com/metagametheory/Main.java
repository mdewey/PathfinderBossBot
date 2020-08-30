package com.metagametheory;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to the Pathfinder Bot Network, lets create a bot");
        var bot = new Bot("Ogre");

        System.out.println(bot);
        bot.PrintActions();

        var whatsGoingOn = new Environment();
        whatsGoingOn.hasLowHealth = Cares.YES;
        whatsGoingOn.caresAboutSelf = Cares.WILDCARD;
        System.out.println(whatsGoingOn);

        var action = bot.Decide(whatsGoingOn);
        System.out.println(action);
    }
}

