package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

/**Interface to model every effect that will be created in the game.
 *
 * @author Hubert Dudowicz
 */
public interface Effect {
	/**Executes the logic for whatever class it's present in.
	 *
	 * @param player Player which the effect will be executed on
	 * @param world World in which the effect will be executed
	 */
	public void execute(Player player, World world);
}
