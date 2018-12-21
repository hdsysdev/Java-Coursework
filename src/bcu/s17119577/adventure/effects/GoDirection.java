package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class GoDirection implements Effect{
    private String direction;

    public GoDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Player player, World world) {
        if (player.getLocation().getNeighbour(direction) != null){
            player.setLocation(player.getLocation().getNeighbour(direction));
            System.out.println("You are in " + player.getLocation().getName() + ".");
        } else {
            System.out.println("There is nothing in that direction.");
        }
    }
}