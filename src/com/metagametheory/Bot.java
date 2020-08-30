package com.metagametheory;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Bot {
    private UUID id = UUID.randomUUID();
    private String name;
    private ArrayList<BotAction> actions = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public Bot(String name) {
        this.name = name;
        this._addBotAction("run");
        this._addBotAction("attack");
    }

    public void PrintActions() {
        actions.forEach(System.out::println);
    }

    private void _addBotAction(String action) {
        var newAction = new BotAction(action);
        this.actions.add(newAction);
    }

    @Override
    public String toString() {
        return "Bot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public BotAction Decide(Environment whatsGoingOn) {
        BotAction selectedAction = null;
        var possibleActions = this.actions.stream().filter(action -> {
            // match on conditions
            return action.DoesMatch(whatsGoingOn);
        }).toArray(BotAction[]::new);
        System.out.println("Matched" + possibleActions.length);
        if (possibleActions.length == 0) {
            selectedAction = new BotAction("Nothing matched");
        } else {
            var isFound = false;
            var attempts = 0;
            while (!isFound) {
                attempts++;
                for (BotAction action : possibleActions) {
                    var threshold = new Random().nextInt(100);
                    if (threshold < action.getStrength()) {
                        selectedAction = action;
                        isFound = true;
                    }
                }
                if (!isFound && attempts >= 10) {
                    System.out.println("not sure, randomly selecting");
                    selectedAction = possibleActions[new Random().nextInt(possibleActions.length)];
                    isFound = true;
                }
            }

        }

        return selectedAction;
    }
}
