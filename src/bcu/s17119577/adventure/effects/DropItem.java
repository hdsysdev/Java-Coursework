package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class DropItem implements Effect{
    private String name;

    public DropItem(String name) {
        this.name = name;
    }

    @Override
    public void execute(Player player, World world) {
        if (world.getItem(name) != null || player.canSeeItem(world.getItem(name))){
            player.dropItem(world.getItem(name));
        } else {
            System.out.println("This player doesn't have this item.");
        }
    }
}