package bcu.s17119577.adventure.test;

import org.junit.Test;

import bcu.s17119577.adventure.effects.GoDirection;
import bcu.s17119577.adventure.model.Location;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

import static org.junit.Assert.assertEquals;

public class GoDirectionTest {
    private final World world = new World();
    private final Location street = world.addLocation("street", "A street");
    private final Location house = world.addLocation("house", "A warm house");
    private final Player player = new Player(street);

    @Test
    public void testAction(){
        street.addNeighbour("in", house);
        GoDirection goDirection = new GoDirection("in");
        assertEquals(player.getLocation().getName(), "street");
        goDirection.execute(player, world);
        assertEquals(player.getLocation().getName(), "house");
    }
}
