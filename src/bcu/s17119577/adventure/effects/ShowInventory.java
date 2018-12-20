package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class ShowInventory implements Effect{


    public ShowInventory() {
    }

    @Override
    public void execute(Player player, World world) {
        if (player.getInventory().size() == 0){
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory: ");
            for (Item item : player.getInventory()){
                System.out.print(item.getName() + ", ");
            }
        }
    }
}