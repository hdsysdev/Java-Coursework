package bcu.s17119577.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
	// TODO: declare fields
	private Location location;
	private List<Item> inventory;
	
	public Player(Location location) {
		// TODO: implement constructor
		this.location = location;
		this.inventory = new ArrayList<>();
	}
	
	public Location getLocation() {
		// TODO: implement getLocation method
		return location;
	}
	
	public void setLocation(Location location) {
		// TODO: implement setLocation method
		this.location = location;
	}
	
	public void takeItem(Item item) {
		// TODO: implement takeItem method
		if (item.getLocation() != location || !item.isPortable()){
			throw new IllegalArgumentException();
		}
		inventory.add(item);
		location.removeItem(item);
	}
	
	public boolean hasItem(Item item) {
		// TODO: implement hasItem method
		return inventory.contains(item);
	}
	
	public boolean canSeeItem(Item item) {
		// TODO: implement canSeeItem method
		return inventory.contains(item) || item.getLocation() == location;
	}
	
	public void dropItem(Item item) {
		// TODO: implement dropItem method
		if (!inventory.contains(item)){
			throw new IllegalArgumentException();
		}
		inventory.remove(item);
		location.addItem(item);
		item.setLocation(location);
	}
	
	public List<Item> getInventory() {
		// TODO: implement getInventory method
		return Collections.unmodifiableList(inventory);
	}
}
