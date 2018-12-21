package bcu.s17119577.adventure.test;

import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Test;
import static org.junit.Assert.*;

import bcu.s17119577.adventure.effects.DropItem;
import bcu.s17119577.adventure.effects.GoDirection;
import bcu.s17119577.adventure.effects.LookItem;
import bcu.s17119577.adventure.effects.LookLocation;
import bcu.s17119577.adventure.effects.Message;
import bcu.s17119577.adventure.effects.Quit;
import bcu.s17119577.adventure.effects.ShowInventory;
import bcu.s17119577.adventure.effects.TakeItem;
import bcu.s17119577.adventure.game.CommandParser;
import bcu.s17119577.adventure.game.QuitException;
import bcu.s17119577.adventure.model.Location;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class CommandParserTest {

    @Test
    public void testLook(){
        assertThat(CommandParser.parsePlayerCommand("look"), instanceOf(LookLocation.class));
    }

    @Test
    public void testLookItem(){
        assertThat(CommandParser.parsePlayerCommand("look item"), instanceOf(LookItem.class));
    }

    @Test
    public void testShowInventory(){
        assertThat(CommandParser.parsePlayerCommand("inventory"), instanceOf(ShowInventory.class));
    }

    @Test
    public void testGo(){
        assertThat(CommandParser.parsePlayerCommand("go direction"), instanceOf(GoDirection.class));
    }

    @Test
    public void testTake(){
        assertThat(CommandParser.parsePlayerCommand("take item"), instanceOf(TakeItem.class));
    }

    @Test
    public void testDrop(){
        assertThat(CommandParser.parsePlayerCommand("drop item"), instanceOf(DropItem.class));
    }

    @Test
    public void testHelp(){
        assertThat(CommandParser.parsePlayerCommand("help"), instanceOf(Message.class));
    }

    @Test
    public void testQuit(){
        assertThat(CommandParser.parsePlayerCommand("quit"), instanceOf(Quit.class));
    }
}
