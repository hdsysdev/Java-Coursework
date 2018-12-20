package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class LookLocation implements Effect{
    private String direction;

    public LookLocation() {

    }

    @Override
    public void execute(Player player, World world) {
        System.out.println("You are currently at a " + player.getLocation());
        System.out.println(player.getLocation().getDescription());
        if (player.getLocation().getItems().isEmpty()){
            System.out.println("There are no items around you");
        } else {
            System.out.println("The items around you are " + player.getLocation().getItems());
        }
        System.out.println("The directions you can go in are " + player.getLocation().getAllDirections());
    }
}