package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

/**An effect that allows the user to change their location in the world.
 *
 * @author Hubert Dudowicz
 */
public class GoDirection implements Effect{
    private String direction;
    /** Constructor that assigns the direction in which the user will travel to change location
     *
     * @param direction The direction of the location the user want's to go to
     */
    public GoDirection(String direction) {
        this.direction = direction;
    }

    /**Executes the logic to move the user from their current location to the new location in the new location is by their current location.
     *
     * @param player The player who will be moved to the new location
     * @param world The world which contains the locations the user will move from and to
     */
    @Override
    public void execute(Player player, World world) {
        if (player.getLocation().getNeighbour(direction) != null){
            player.setLocation(player.getLocation().getNeighbour(direction));
            System.out.println("You are in " + player.getLocation().getName() + ".");
        } else {
            System.out.println("There is nothing in that direction.");
        }
    }
}