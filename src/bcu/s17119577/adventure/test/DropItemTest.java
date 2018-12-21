package bcu.s17119577.adventure.test;

import org.junit.Test;

import bcu.s17119577.adventure.effects.GoDirection;
import bcu.s17119577.adventure.model.Action;
import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Location;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DropItemTest {
    private final World world = new World();
    private final Location street = world.addLocation("street", "A street");
    private final Player player = new Player(street);

    @Test
    public void testAction(){
        Item spade = world.addItem("spade", "A spade");
        street.addItem(spade);
        spade.setPortable(true);
        player.takeItem(spade);
        assertTrue(player.hasItem(spade));
        player.dropItem(spade);
        assertFalse(player.hasItem(spade));
    }
}
