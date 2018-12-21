package bcu.s17119577.adventure.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bcu.s17119577.adventure.effects.Effect;
import bcu.s17119577.adventure.effects.LookLocation;
import bcu.s17119577.adventure.effects.Message;
import bcu.s17119577.adventure.effects.Quit;
import bcu.s17119577.adventure.model.Action;
import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Location;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class Main implements Runnable{
    public World world;

    public static void main(String[] args)  {
        World world = new World();
        Location house =
                world.addLocation("house", "You are in a small village house.");
        Location street =
                world.addLocation("street", "You are on the main street of the village.");

        house.addNeighbour("out", street);
        street.addNeighbour("in", house);

        Item clock = world.addItem("clock", "It is an old grandfather clock.");
        house.addItem(clock);

        Item hammer = world.addItem("hammer", "It is a brand new hammer.");
        street.addItem(hammer);
        hammer.setPortable(true);

        Action useHammer = world.addAction("use hammer");
        useHammer.addRequiredItem(hammer);
        useHammer.addRequiredItem(clock);
        useHammer.addEffect(new Message("You hit the clock with the hammer."));
        useHammer.addEffect(new Message("The clock shatters into pieces."));
        useHammer.addEffect(new Message("THE END"));
        useHammer.addEffect(new Quit());

        world.setStartingLocation(house);
        world.onStart(new LookLocation());

        Player player = new Player(world.getStartingLocation());

        Main main = new Main(world);
        main.run();
    }

    public Main(World world){
        this.world = world;
    }

    @Override
    public void run() {
        Player player = new Player(world.getStartingLocation());
        for (Effect effect: world.getStartEffects()){
            effect.execute(player, world);
        }

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in)
        );

        while(true) {
            try {
            System.out.print("> ");
            String command = keyboard.readLine();
                CommandParser.parsePlayerCommand(command).execute(player, world);
            } catch(IOException | NullPointerException ex) {
                System.out.println("That is not a valid command.");
            } catch (QuitException ex){
                System.exit(0);
            }
        }
    }
}
