package bcu.s17119577.adventure.model;

import bcu.s17119577.adventure.effects.Effect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Action {
	// TODO: declare fields
	private String name;
	private List<Item> requiredItems;
	private List<Effect> effects;

	public Action(String name) {
		// TODO: implement constructor
		this.name = name;
		requiredItems = new ArrayList<>();
		effects = new ArrayList<>();
	}
	
	public String getName() {
		// TODO: implement getName method
		return name;
	}
	
	public void addRequiredItem(Item item) {
		// TODO: implement addRequiredItem method
		requiredItems.add(item);
	}
	
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
	
	public void addEffect(Effect effect) {
		// TODO: implement addEffect method
		effects.add(effect);
	}
	
	public List<Effect> getEffects() {
		// TODO: implement getEffects method
		return Collections.unmodifiableList(effects);
	}
}
