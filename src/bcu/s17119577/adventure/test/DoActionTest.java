package bcu.s17119577.adventure.test;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import bcu.s17119577.adventure.effects.DoAction;
import bcu.s17119577.adventure.effects.GoDirection;
import bcu.s17119577.adventure.model.Action;
import bcu.s17119577.adventure.model.Location;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class DoActionTest {
    private final World world = new World();
    private final Location street = world.addLocation("street", "A street");
    private final Location house = world.addLocation("house", "A warm house");
    private final Player player = new Player(street);

    @Test
    public void testAction(){
        street.addNeighbour("inside", house);
        Action moveIn = world.addAction("move inside");
        moveIn.addEffect(new GoDirection("inside"));
        assertEquals(player.getLocation().getName(), "street");
        moveIn.getEffects().get(0).execute(player, world);
        assertEquals(player.getLocation().getName(), "house");
    }
}
