package bcu.s17119577.adventure.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
	// TODO: declare fields
	private String name;
	private String description;
	private List<Item> items;
	private Map<String, Location> neigbours;

	public Location(String name, String description) {
		// TODO: implement constructor
		this.name = name;
		this.description = description;
		this.items = new ArrayList<>();
		this.neigbours = new HashMap<>();
	}
	
	public String getName() {
		// TODO: implement getName method
		return name;
	}
	
	public String getDescription() {
		// TODO: implement getDescription method
		return description;
	}
	
	public void addNeighbour(String direction, Location neighbour) {
		// TODO: implement addNeighbour method
		neigbours.put(direction, neighbour);

	}
	
	public Location getNeighbour(String direction) {
		// TODO: implement getNeighbour method
		return neigbours.getOrDefault(direction, null);
	}
	
	public Collection<String> getAllDirections() {
		// TODO: implement getAllDirections method
		return Collections.unmodifiableCollection(neigbours.keySet());
	}
	
	public List<Item> getItems() {
		// TODO: implement getItems method
		return Collections.unmodifiableList(items);
	}
	
	public void addItem(Item item) {
		// TODO: implement addItem method
		items.add(item);
		item.setLocation(this);
	}
	
	public boolean hasItem(Item item) {
		// TODO: implement hasItem method
		return items.contains(item);
	}
	
	public void removeItem(Item item) {
		// TODO: implement removeItem method
		if (item.getLocation() != this){
			throw new IllegalArgumentException();
		}
		items.remove(item);
		item.setLocation(null);
	}
}
