package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class LookItem implements Effect{
    private String name;

    public LookItem(String name) {
        this.name = name;
    }

    @Override
    public void execute(Player player, World world) {
        if (world.getItem(name) != null || player.canSeeItem(world.getItem(name))){
            System.out.println(world.getItem(name).getDescription());
        } else {
            System.out.println("This player cannot see this item.");
        }
    }
}