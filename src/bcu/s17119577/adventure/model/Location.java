package bcu.s17119577.adventure.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**This class models a place within the game.
 * <p>This class models a location in the game. It stores information like the name and description of the place as well as a list of items present in that location
 * and what locations can be reached from this location, refereed to as neighbours.</p>
 *
 * @author Hubert Dudowicz
 */
public class Location {
	private String name;
	private String description;
	private List<Item> items;
	private Map<String, Location> neighbours;

	/**Constructor to initialise a new location with a name, description and no items or neighbours.
	 *
	 * @param name Name of the new location
	 * @param description Description of the new location
	 */
	public Location(String name, String description) {
		this.name = name;
		this.description = description;
		this.items = new ArrayList<>();
		this.neighbours = new HashMap<>();
	}

	/**Gets the name of this location
	 *
	 */
	public String getName() {
		return name;
	}
	/**Gets the description of this location
	 *
	 */
	public String getDescription() {
		return description;
	}
	/**Adds a neighbour to this location, linked by the direction.
	 *
	 * @param direction The direction in which the new neighbour is located
	 * @param neighbour The location object of the neighbouring location
	 */
	public void addNeighbour(String direction, Location neighbour) {
		neighbours.put(direction, neighbour);

	}
	/**Fetches the location object of a neighbouring location based on the direction
	 *
	 * @param direction Direction of the desired neighbour Location object
	 */
	public Location getNeighbour(String direction) {
		return neighbours.getOrDefault(direction, null);
	}
	/**Fetches a collection of all directions present with a neighbour
	 *
	 */
	public Collection<String> getAllDirections() {
		return Collections.unmodifiableCollection(neighbours.keySet());
	}
	/**Fetches a list of all the items present in the location on which this method is called
	 *
	 */
	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}
	/**Adds an item to the location on which this method is called
	 *
	 * @param item The item which will be added to this location
	 */
	public void addItem(Item item) {
		items.add(item);
		item.setLocation(this);
	}
	/**Checks if the passed item is present in the location on which this method is called
	 *
	 * @param item The item which will be checked for presence in the current location
	 *
	 */
	public boolean hasItem(Item item) {
		return items.contains(item);
	}
	/**Method that removes a given item from the location on which the method is called.
	 *
	 * @param item The item which will be removed from the location
	 */
	public void removeItem(Item item) {
		if (item.getLocation() != this){
			throw new IllegalArgumentException();
		}
		items.remove(item);
		item.setLocation(null);
	}
}
