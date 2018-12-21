package bcu.s17119577.adventure.test;

import org.junit.Test;

import bcu.s17119577.adventure.effects.Quit;
import bcu.s17119577.adventure.game.QuitException;
import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Location;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuitTest {
    private final World world = new World();
    private final Location street = world.addLocation("street", "A street");
    private final Player player = new Player(street);

    @Test(expected = QuitException.class)
    public void testAction(){
        Quit quit = new Quit();
        quit.execute(player, world);
    }
}
