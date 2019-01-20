package bcu.s17119577.adventure.game;

import bcu.s17119577.adventure.effects.DoAction;
import bcu.s17119577.adventure.effects.DropItem;
import bcu.s17119577.adventure.effects.Effect;
import bcu.s17119577.adventure.effects.GoDirection;
import bcu.s17119577.adventure.effects.LookItem;
import bcu.s17119577.adventure.effects.LookLocation;
import bcu.s17119577.adventure.effects.Message;
import bcu.s17119577.adventure.effects.Quit;
import bcu.s17119577.adventure.effects.ShowInventory;
import bcu.s17119577.adventure.effects.TakeItem;
/**Class for parsing the inputted commands inputted by the user.
 * <p>This class stores the static parsePlayerCommand which is the function that is responsible for parsing the user's input and running the appropriate Effect class.
 * Otherwise, it outputs a message if the command is not valid.</p>
 * @author Hubert Dudowicz
 */
public class CommandParser {
	private static final String HELP_MESSAGE =
		"Commands:\n" +
		"    look              Look around you.\n" +
		"    look [item]       Look at an item.\n" +
		"    inventory         Look at your inventory.\n" +
		"    go [direction]    Walk in a direction.\n" +
		"    take [item]       Take an item.\n" +
		"    drop [item]       Drop an item.\n" +
		"    help              Show this help message.\n" +
		"    quit              Exit the game.";

	/**Takes command parameter and runs the correct effect.
	 *
	 * <p>This function takes the command the user typed in and runs the correct effect according to
	 * the command typed in.</p>
	 *
	 * @param command The command the user has typed in
	 * @return Returns the correct effect based on the command typed in
	 */
	public static Effect parsePlayerCommand(String command) {
		// TODO: complete implementation of parsePlayerCommand
		String[] parts = command.split(" ");
		String firstPart = parts[0];

		if("look".equalsIgnoreCase(firstPart) && parts.length == 1) {
			return new LookLocation();
		} else if("look".equalsIgnoreCase(firstPart) && parts.length == 2) {
			return new LookItem(parts[1]);
		} else if("inventory".equalsIgnoreCase(firstPart)) {
			return new ShowInventory();
		} else if("go".equalsIgnoreCase(firstPart) && parts.length == 2) {
			return new GoDirection(parts[1]);
		} else if("take".equalsIgnoreCase(firstPart) && parts.length == 2) {
			return new TakeItem(parts[1]);
		} else if("drop".equalsIgnoreCase(firstPart) && parts.length == 2) {
			return new DropItem(parts[1]);
		} else if("help".equalsIgnoreCase(firstPart)) {
			return new Message(HELP_MESSAGE);
		} else if("quit".equalsIgnoreCase(firstPart)) {
			return new Quit();
		} else {
			return new DoAction(command);
		}

	}
}
