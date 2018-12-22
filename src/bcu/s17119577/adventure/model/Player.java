package bcu.s17119577.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**This class models the player in the game.
 * <p>This class contains variables and methods that are to be used with the player in the game.</p>
 *
 * @author Hubert Dudowicz
 */
public class Player {
	private Location location;
	private List<Item> inventory;

	/** Constructor to create a new player in the given location with an empty inventory.
	 *
	 * @param location The location in which the player will be created
	 */
	public Player(Location location) {
		this.location = location;
		this.inventory = new ArrayList<>();
	}

	/**Fetches the current location of the player.
	 *
	 * @return Player's current location
	 */
	public Location getLocation() {
		return location;
	}

	/**Sets the player's location to a given location
	 *
	 * @param location The new location which the player's location will be changed to
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**Makes the player pick up a given item, if possible, and store it in their inventory.
	 *
	 * @param item The item which the player is to pick up
	 */
	public void takeItem(Item item) {
		if (item.getLocation() != location || !item.isPortable()){
			throw new IllegalArgumentException();
		}
		inventory.add(item);
		location.removeItem(item);
	}

	/**Checks if the person has the given item in their inventory
	 *
	 * @param item The item which will be checked for presence in the players inventory
	 * @return Weather or not the player's inventory contains a given item
	 */
	public boolean hasItem(Item item) {
		return inventory.contains(item);
	}

	/**Checks if the person can see their item in their inventory or location
	 *
	 * @param item The item which will be checked for accessibility to the player
	 * @return Weather on not the player's inventory contains an item or the item is in the players location
	 */
	public boolean canSeeItem(Item item) {
		return inventory.contains(item) || item.getLocation() == location;
	}

	/**Drops a given item at the current location if it is present in the persons inventory
	 *
	 * @param item The item which should be dropped
	 */
	public void dropItem(Item item) {
		if (!inventory.contains(item)){
			throw new IllegalArgumentException();
		}
		inventory.remove(item);
		location.addItem(item);
		item.setLocation(location);
	}

	/**Fetches a list of the player's inventory
	 *
	 * @return List of the players inventory
	 */
	public List<Item> getInventory() {
		return Collections.unmodifiableList(inventory);
	}
}
