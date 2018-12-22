package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

/**An effect that removes a given item from the player's inventory.
 *
 * @author Hubert Dudowicz
 */
public class DropItem implements Effect{
    private String name;

    /**Constructor that assigns the name of the item that will be dropped.
     *
     * @param name Name of the item to be dropped
     */
    public DropItem(String name) {
        this.name = name;
    }

    /**Executes the drop item effect. Drops the given item from the player's inventory
     *
     * @param player Current player from who's inventory the item will be dropped
     * @param world The world containing the item which will be dropped from the players inventory
     */
    @Override
    public void execute(Player player, World world) {
        if (world.getItem(name) != null && player.getInventory().contains(world.getItem(name))){
            player.dropItem(world.getItem(name));
            System.out.println("You have dropped the " + name);
        } else {
            System.out.println("This player doesn't have this item.");
        }
    }
}