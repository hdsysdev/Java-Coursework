package bcu.s17119577.adventure.game;

import bcu.s17119577.adventure.effects.Effect;
import bcu.s17119577.adventure.effects.LookLocation;
import bcu.s17119577.adventure.model.Item;

public class CommandParser {
	public static final String HELP_MESSAGE =
		"Commands:\n" +
		"    look              Look around you.\n" +
		"    look [item]       Look at an item.\n" +
		"    inventory         Look at your inventory.\n" +
		"    go [direction]    Walk in a direction.\n" +
		"    take [item]       Take an item.\n" +
		"    drop [item]       Drop an item.\n" +
		"    help              Show this help message.\n" +
		"    quit              Exit the game.";
	
	public static Effect parsePlayerCommand(String command) {
		// TODO: complete implementation of parsePlayerCommand
		switch (command){
			case "look": return new LookLocation().execute();
			case "look [item]":
		}
//		BufferedReader keyboard = new BufferedReader(
////				new InputStreamReader(System.in)
////		);
////
////		System.out.println("Address book");
////		while(true) {
////			System.out.print("> ");
////			String command = keyboard.readLine();
////			if("exit".equalsIgnoreCase(command)) {
////				break;
////			}
////
////			try {
////				parseAndExecute(command);
////			} catch(AlreadyPresentException ex) {
////				System.out.println("The entry for " + ex.getName() + " already exists.");
////			} catch(NotPresentException ex) {
////				System.out.println("The entry for " + ex.getName() + " does not exist.");
////			} catch(InvalidCommandException ex) {
////				System.out.println("Invalid command (enter 'help' to see the valid commands).");
////			}
////		}

	}
}
