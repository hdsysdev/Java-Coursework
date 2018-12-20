package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class Message implements Effect{
    private String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public void execute(Player player, World world) {
        System.out.println(message);
    }
}