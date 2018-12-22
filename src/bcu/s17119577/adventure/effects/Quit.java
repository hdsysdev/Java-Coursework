package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.game.QuitException;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

/**Effect that quits the game by throwing a custom QuitException
 *
 * @author Hubert Dudowicz
 */
public class Quit implements Effect{
    /**Constructor to create the Quit object
     *
     */
    public Quit() {
    }

    /**Throws a QuitException which eventually closes the game when caught
     *
     * @param world The world of the game which is being quit
     * @param player The player of the game which is being quit
     */
    @Override
    public void execute(Player player, World world) {
        throw new QuitException();
    }
}