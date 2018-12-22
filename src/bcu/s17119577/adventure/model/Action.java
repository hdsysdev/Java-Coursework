package bcu.s17119577.adventure.model;

import bcu.s17119577.adventure.effects.Effect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**This class models all possible actions that can be created in the game.
 *<p>Using this class, one can create any action to be used in the game by using the built in fields and methods.</p>
 *
 * @author Hubert Dudowicz
 */
public class Action {

	private String name;
	private List<Item> requiredItems;
	private List<Effect> effects;

	/**Constructor to create an action with an action and no required items or effects.
	 *
	 * @param name This is the name of the action
	 */
	public Action(String name) {
		// TODO: implement constructor
		this.name = name;
		requiredItems = new ArrayList<>();
		effects = new ArrayList<>();
	}
	/**Gets the name of the action.
	 *
	 */
	public String getName() {
		// TODO: implement getName method
		return name;
	}
	/**Adds an item required for the completion of this action.
	 *
	 * @param item The item required for the completion of this action
	 */
	public void addRequiredItem(Item item) {
		// TODO: implement addRequiredItem method
		requiredItems.add(item);
	}

	/**Decides if the action can be completed based on if the player has or can see the items required for the action.
	 *
	 * @param player The player who will be completing the action
	 */
	public boolean isAllowed(Player player) {
		// TODO: implement isAllowed method
		boolean allowed = true;
		for (Item item : requiredItems){
			if (!player.canSeeItem(item)){
				allowed = false;
			}
		}
		return allowed;
	}
	/**Method to add an effect that will be caused by the action
	 *
	 * @param effect The effect the action will trigger
	 */
	public void addEffect(Effect effect) {
		// TODO: implement addEffect method
		effects.add(effect);
	}
	/**Returns the list of effects the action will cause
	 *
	 */
	public List<Effect> getEffects() {
		// TODO: implement getEffects method
		return Collections.unmodifiableList(effects);
	}
}
