package bcu.s17119577.adventure.test;

import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Location;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LocationTest {
	private final Location house = new Location("house", "You are in a small village house.");
	
	@Test
	public void testGetName() {
		assertEquals("house", house.getName());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("You are in a small village house.", house.getDescription());
	}
	
	@Test
	public void noItems() {
		assertEquals(Collections.emptyList(), house.getItems());
	}
	
	// TODO: more unit tests

	@Test
	public void testItems() {
		Item table = new Item("Table", "A small table");
		Item painting = new Item("Painting", "A painting hanging on the wall");
		ArrayList<Item> items = new ArrayList<>();
		items.add(table);
		items.add(painting);

		house.addItem(table);
		house.addItem(painting);
		assertEquals(house.getItems(), items);
	}

	@Test
	public void testRemoveItem() {
		Item table = new Item("Table", "A small table");
		Item painting = new Item("Painting", "A painting hanging on the wall");
		ArrayList<Item> items = new ArrayList<>();
		items.add(table);
		items.add(painting);
		house.addItem(table);
		house.addItem(painting);
		assertEquals(house.getItems(), items);

		house.removeItem(table);
		items.remove(table);
		assertEquals(house.getItems(), items);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveItemNotInLocation() {
		Item table = new Item("Table", "A small table");

		house.removeItem(table);
	}

	@Test
	public void testHasItem() {
		Item painting = new Item("Painting", "A painting hanging on the wall");
		house.addItem(painting);
		assertTrue(house.hasItem(painting));
	}

	@Test
	public void testNeighbour(){
		Location neighbour = new Location("outside", "You are on a street");
		house.addNeighbour("outside", neighbour);
		assertEquals(house.getNeighbour("outside"), neighbour);
	}

	@Test
	public void testDirections() {
		Set<String> directions = new HashSet<>(Arrays.asList("left", "forward", "right"));
		house.addNeighbour("left", new Location("room1", "You are in an empty room"));
		house.addNeighbour("forward", new Location("room2", "You are in a room with a single chair"));
		house.addNeighbour("right", new Location("room3", "You are in a room full of tins of beans"));
		assertEquals(house.getAllDirections().toArray(), directions.toArray());
	}


}
