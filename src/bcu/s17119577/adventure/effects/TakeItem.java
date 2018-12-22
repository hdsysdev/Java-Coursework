package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

/**Effect that allows the player to take an item and place it in their inventory
 *
 * @author Hubert Dudowicz
 */
public class TakeItem implements Effect{
    private String name;
    /**Constructor that creates the effect object and assigns the name of the item being taken
     *
     */
    public TakeItem(String name) {
       this.name = name;
    }

    /**Puts the given item from the location into the player's inventory if the item is in the players location and can be picked up.
     *
     */
    @Override
    public void execute(Player player, World world) {
        Item item = world.getItem(name);

        if (player.hasItem(item) || item.getLocation() != player.getLocation() || !item.isPortable() ){
            System.out.println("The player cannot take the " + name);
        } else {
            player.takeItem(item);
            System.out.println("You have taken the " + name);
        }
    }
}