package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

/**Effects that allows the player to view their inventory
 *
 * @author Hubert Dudowicz
 */
public class ShowInventory implements Effect{

    /**Empty constructor to create object for execution
     *
     */
    public ShowInventory() {
    }

    /**Displays the contents of the players inventory or prints a message if the player has no items in their inventory.
     *
     * @param player Player who's inventory is being displayed
     * @param world World in which the player exists
     */
    @Override
    public void execute(Player player, World world) {
        if (player.getInventory().size() == 0){
            System.out.println("Your inventory is empty.");
        } else {
            System.out.print("Your inventory: ");
            for (Item item : player.getInventory()){
                System.out.println(item.getName() + " ");
            }
        }
    }
}