package bcu.s17119577.adventure.effects;


import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

/**Effect that allows the user to inspect their current location by printing out a description of the location.
 *
 * @author Hubert Dudowicz
 *
 */
public class LookLocation implements Effect{

    /**Constructor to create the effect object
     *
     */
    public LookLocation() {
    }

    /**Tells the player information about their surroundings, what items are around them and what directions they can go in to get to new places.
     *
     * @param player Player who's location is being inspected
     * @param world World where the location being inspected is located.
     */
    @Override
    public void execute(Player player, World world) {
        System.out.println(player.getLocation().getDescription());
        if (player.getLocation().getItems().isEmpty()){
            System.out.println("There are no items around you");
        } else {
            String items = "";
            for (Item item: player.getLocation().getItems()){
                items += item.getName() + " ";
            }
            System.out.println("The items around you are " + items);
        }
        System.out.println("The directions you can go in are " + player.getLocation().getAllDirections());
    }
}