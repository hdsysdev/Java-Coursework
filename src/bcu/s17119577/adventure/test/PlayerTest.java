package bcu.s17119577.adventure.test;

import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.Location;
import bcu.s17119577.adventure.model.World;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlayerTest {
	private final Location house = new Location("house", "You are in a small village house.");
	private final Location street = new Location("street", "You are on the main street of the village.");
	private final Player player = new Player(street);

	
	@Test
	public void testGetLocation() {
		assertSame(street, player.getLocation());
	}
	
	@Test
	public void testSetLocation() {
		player.setLocation(house);
		assertSame(house, player.getLocation());
	}
	
	@Test
	public void testInventory() {
		assertEquals(Collections.emptyList(), player.getInventory());
	}
	
	// TODO: more unit tests

	@Test
	public void testFullInventory() {
		Item spoon = new Item("spoon", "A spoon");
		street.addItem(spoon);
		spoon.setPortable(true);
		Item pasta = new Item("pasta", "A single piece of pasta");
		street.addItem(pasta);
		pasta.setPortable(true);
		List<Item> items = new ArrayList<>(Arrays.asList(spoon, pasta));

		player.takeItem(spoon);
		player.takeItem(pasta);
		assertEquals(player.getInventory(), items);
	}

	@Test
	public void testTakeItem() {
		Item spoon = new Item("spoon", "A spoon");
		street.addItem(spoon);
		spoon.setPortable(true);
		player.takeItem(spoon);
		assertTrue(player.hasItem(spoon));
	}

	@Test
	public void testCanSee() {
		Item spoon = new Item("spoon", "A spoon");
		street.addItem(spoon);
		assertTrue(player.canSeeItem(spoon));
	}
}
