package bcu.s17119577.adventure.test;

import org.junit.Test;

import bcu.s17119577.adventure.effects.Effect;
import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Location;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

import static org.junit.Assert.*;

public class WorldTest {
    private final World world = new World();

    @Test
    public void testStartingLocation(){
        Location street = new Location("street", "A street in the middle of nowhere");
        world.setStartingLocation(street);
        assertEquals(world.getStartingLocation(), street);
    }

    @Test
    public void testAddGetItem() {
        world.addItem("bottle", "A plastic water bottle");
        assertEquals(world.getItem("bottle").getDescription(), "A plastic water bottle");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateItem() {
        world.addItem("bottle", "A plastic water bottle");
        world.addItem("bottle", "A second plastic water bottle");
    }

    @Test
    public void testAddGetLocation() {
        world.addLocation("house", "An old house");
        assertEquals(world.getLocation("house").getName(), "house");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateLocation() {
        world.addLocation("house", "A house");
        world.addLocation("house", "Another house");
    }

    @Test
    public void testAddGetAction() {
        world.addAction("jump");
        assertEquals(world.getAction("jump").getName(), "jump");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAction() {
        world.addAction("jump");
        world.addAction("jump");
    }

    @Test
    public void testStartEffects() {
        Effect effect = new Effect() {
            @Override
            public void execute(Player player, World world) {
                System.out.println("Dummy effect");
            }
        };
        world.onStart(effect);
        assertTrue(world.getStartEffects().contains(effect));
    }
}
