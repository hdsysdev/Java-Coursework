package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

/**A simple effect that prints a message passed to it.
 *
 * @author Hubert Dudowicz
 */
public class Message implements Effect{
    private String message;
    /**Constructor to create the object and assign the message that will be printed
     *
     */
    public Message(String message) {
        this.message = message;
    }

    /**Prints the assigned message to the console
     *
     * @param player The current player
     * @param world The current world
     */
    @Override
    public void execute(Player player, World world) {
        System.out.println(message);
    }
}