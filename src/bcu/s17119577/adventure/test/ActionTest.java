package bcu.s17119577.adventure.test;

import org.junit.Test;

import bcu.s17119577.adventure.effects.Effect;
import bcu.s17119577.adventure.model.Action;
import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Location;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

import static org.junit.Assert.*;

public class ActionTest {
    private final Action action = new Action("dig");
    private final Location road = new Location("road", "A dirt road");
    private final Player player = new Player(road);

    @Test
    public void testGetName(){
       assertEquals(action.getName(), "dig");
    }

    @Test
    public void notAllowedTest() {
        Item spade = new Item("spade", "A spade for digging");
        action.addRequiredItem(spade);
        assertFalse(action.isAllowed(player));
    }

    @Test
    public void testRequiredItemAllowed() {
        Item spade = new Item("spade", "A spade for digging");
        action.addRequiredItem(spade);
        road.addItem(spade);
        assertTrue(action.isAllowed(player));
    }

    @Test
    public void testAddGetEffect() {
        Effect effect = new Effect() {
            @Override
            public void execute(Player player, World world) {
                System.out.println("You've dug a hole.");
            }
        };
        action.addEffect(effect);
        assertTrue(action.getEffects().contains(effect));
    }
}
