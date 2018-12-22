package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

/**Effect that allows the player to inspect and item's name and description
 *
 * @author Hubert Dudowicz
 */
public class LookItem implements Effect{
    private String name;

    /**Constructor to set the name of the item the player will be inspecting
     *
     * @param name The name of the item the player will be inspecting
     */
    public LookItem(String name) {
        this.name = name;
    }

    /**Inspects the given item if the item exists and the player can see it otherwise a message is printed.
     *
     * @param player The player who will be inspecting the item
     * @param world The world in which the inspected item is present in
     */
    @Override
    public void execute(Player player, World world) {
        if (world.getItem(name) != null || player.canSeeItem(world.getItem(name))){
            System.out.println(world.getItem(name).getDescription());
        } else {
            System.out.println("This player cannot see this item.");
        }
    }
}