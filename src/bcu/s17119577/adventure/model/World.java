package bcu.s17119577.adventure.model;

import bcu.s17119577.adventure.effects.Effect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**A model for the world in which the game will be played.
 * <p>This class models the variables and functions that are required by the world the game will be played. This class stores all items, locations, actions and effects
 * in the game.</p>
 *
 * @author Hubert Dudowicz
 */
public class World {
	private Location startingLocation;
	private Map<String, Item> itemMap;
	private Map<String, Location> locationMap;
	private Map<String, Action> actionMap;
	private List<Effect> effectList;

	/**A constructor that initialises an empty world with nothing in it.
	 *
	 */
	public World() {
		startingLocation = null;
		itemMap = new HashMap<>();
		locationMap = new HashMap<>();
		actionMap = new HashMap<>();
		effectList = new ArrayList<>();
	}

	/**Fetches the starting location in which the player will spawn in.
	 *
	 */
	public Location getStartingLocation() {
		return startingLocation;
	}

	/**Assigns the player's starting location to a given location.
	 *
	 * @param location The location which the players spawn location will be assigned as
	 */
	public void setStartingLocation(Location location) {
		startingLocation = location;
	}

	/**Fetches an item with a given name or returns null if no such item exists
	 *
	 * @param name The name of an item you're trying to fetch
	 */
	public Item getItem(String name) {
		return itemMap.getOrDefault(name, null);
	}

	/**Adds a new item to the game if no item with the same name exists.
	 *
	 * @param name Name that will be assigned to the new item
	 * @param description Description that will be assigned to the new item
	 */
	public Item addItem(String name, String description) {
		if (itemMap.containsKey(name)){
			throw new IllegalArgumentException();
		}
		itemMap.put(name, new Item(name, description));
		return itemMap.get(name);
	}

	/**Fetches a location in the game based on the name of the location
	 *
	 * @param name Name of the location to be fetched
	 */
	public Location getLocation(String name) {
		return locationMap.getOrDefault(name, null);
	}

	/**Adds a new location to the game with a given name and description
	 *
	 * @param name Name to be assigned to the new location
	 * @param description Description to be assigned to the new location
	 */
	public Location addLocation(String name, String description) {
		if (locationMap.containsKey(name)){
			throw new IllegalArgumentException();
		}
		locationMap.put(name, new Location(name, description));
		return locationMap.get(name);
	}

	/**Fetches an action based on a given name
	 *
	 * @param name Name of the action to be fetched
	 */
	public Action getAction(String name) {
		return actionMap.getOrDefault(name, null);
	}

	/**Adds a new action if no action with the same name exists.
	 *
	 * @param name Name of the new action
	 */
	public Action addAction(String name) {
		if (actionMap.containsKey(name)){
			throw new IllegalArgumentException();
		}
		actionMap.put(name, new Action(name));
		return actionMap.get(name);
	}

	/**Adds effect to be ran at the start of the game
	 *
	 * @param effect Effect that will be added to the list of effects that are ran at the start of the game
	 */
	public void onStart(Effect effect) {
		effectList.add(effect);
	}

	/**Gets the list of effects that are ran at the start of the game
	 *
	 */
	public List<Effect> getStartEffects() {
		return Collections.unmodifiableList(effectList);
	}
}

