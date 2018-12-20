package bcu.s17119577.adventure.model;

import bcu.s17119577.adventure.effects.Effect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {
	// TODO: declare fields
	private Location startingLocation;
	private Map<String, Item> itemMap;
	private Map<String, Location> locationMap;
	private Map<String, Action> actionMap;
	private List<Effect> effectList;

	public World() {
		// TODO: implement constructor
		startingLocation = null;
		itemMap = new HashMap<>();
		locationMap = new HashMap<>();
		actionMap = new HashMap<>();
		effectList = new ArrayList<>();
	}
	
	public Location getStartingLocation() {
		// TODO: implement getStartingLocation method
		return startingLocation;
	}
	
	public void setStartingLocation(Location location) {
		// TODO: implement setStartingLocation method
		startingLocation = location;
	}
	
	public Item getItem(String name) {
		// TODO: implement getItem method
		return itemMap.getOrDefault(name, null);
	}
	
	public Item addItem(String name, String description) {
		// TODO: implement addItem method
		if (itemMap.containsKey(name)){
			throw new IllegalArgumentException();
		}
		itemMap.put(name, new Item(name, description));
		return itemMap.get(name);
	}
	
	public Location getLocation(String name) {
		// TODO: implement getLocation method
		return locationMap.getOrDefault(name, null);
	}
	
	public Location addLocation(String name, String description) {
		// TODO: implement addLocation method
		if (locationMap.containsKey(name)){
			throw new IllegalArgumentException();
		}
		locationMap.put(name, new Location(name, description));
		return locationMap.get(name);
	}

	public Action getAction(String name) {
		// TODO: implement getAction method
		return actionMap.getOrDefault(name, null);
	}
	
	public Action addAction(String name) {
		// TODO: implement addAction method
		if (actionMap.containsKey(name)){
			throw new IllegalArgumentException();
		}
		actionMap.put(name, new Action(name));
		return actionMap.get(name);
	}
	
	public void onStart(Effect effect) {
		// TODO: implement onStart method
		effectList.add(effect);
	}
	
	public List<Effect> getStartEffects() {
		// TODO: implement getStartEffects method
		return Collections.unmodifiableList(effectList);
	}
}

