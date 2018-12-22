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

/**The main class contains the entry point for the program
 * <p>This class contains the main(String[] args) method which is the entry point for the program, this method contains all of the code that creates the game out of the
 * different pre-written classes. The class implements the Runnable interface which is used to indicate an object that can run on a thread. The run() method is required
 * by the Runnable interface and in this case it parses the user's input into commands which are processed by the Command Parser</p>
 *
 * @author Hubert Dudowicz
 */
public class Main implements Runnable{
    private World world;
    /**The main method is the entry point from the program.
     * <p>This method is where the program starts executing from. In this method, the world, locations, items, etc are created as well as all of their properties being
     * assigned. For usage see the documentation for the classes in the model part of the package.</p>
     *
     */
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
    /**The constructor for the main class takes the World as a parameter and initialises the private World object for use in the run() method.
     *
     * @param world The object to be used as the game world
     */
    public Main(World world){
        this.world = world;
    }

    /**The run method creates the player and takes user input from the keyboard and parses it using the CommandParser class.
     */
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
