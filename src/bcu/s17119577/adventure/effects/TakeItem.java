package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class TakeItem implements Effect{
    private String name;

    public TakeItem(String name) {
       this.name = name;
    }

    @Override
    public void execute(Player player, World world) {
        Item item = world.getItem(name);

        if (player.hasItem(item) || item.getLocation() != player.getLocation() || !item.isPortable() || world.getItem("hammer") == null){
            System.out.println("The player cannot take the " + name);
        } else {
            player.takeItem(item);
            System.out.println("You have taken the " + name);
        }
    }
}