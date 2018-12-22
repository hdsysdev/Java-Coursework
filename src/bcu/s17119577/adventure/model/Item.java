package bcu.s17119577.adventure.model;

/**This class models every item in the game.
 * <p> This class contains all the variables that an item in the game would need as well as the getters and setters for those variables.</p>
 *
 * @author Hubert Dudowicz
 */
public class Item {
	private String name;
	private String description;
    private Location location;
    private boolean portable;
	/**The constructor creates a non portable item with a given name, description and no location.
	 *
	 * @param name Name of the item
	 * @param description Description describing what the item is
	 */
	public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.location = null;
        this.portable = false;
	}

	/**Gets the items name.
	 *
	 * @return Item's name
	 */
	public String getName() {
		return name;
	}
	/**Gets the item's description.
	 *
	 * @return Item's description
	 */
	public String getDescription() {
		return description;
	}
	/**Gets the location of the item.
	 *
	 * @return Item's location
	 */
	public Location getLocation() {
		return location;
	}
	/** Sets the item's location
	 *
	 * @param location New location of the item
	 */
	public void setLocation(Location location) {
        this.location = location;
	}
	/** Method used to tell if the item can be picked up by the player.
	 *
	 * @return If the item is portable or not
	 */
	public boolean isPortable() {
		return portable;
	}
	/**Sets if the item can be picked up by the user or not.
	 *
	 * @param portable Boolean determining if the item can be picked up
	 */
	public void setPortable(boolean portable) {
		// TODO: implement setPortable method
	    this.portable = portable;
	}
}
