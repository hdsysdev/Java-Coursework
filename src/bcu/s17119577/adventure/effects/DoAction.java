package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

/**Gets an action of a given name from the world and executes all of it's effects.
 * <p>This class gets every action from the world's effects list and executes all of them if the player is allowed to perform this action.</p>
 *
 * @author Hubert Dudowicz
 */
public class DoAction implements Effect{
    private String actionName;

    /**Constructor to instantiate an effect with a given name
     *
     * @param name Name to give to effect action
     */
    public DoAction(String name) {
        this.actionName = name;
    }
    /**Executes all of the effects from the world if allowed
     *
     * @param player Current player to be used in the effects
     * @param world The world from and in which the effects will be executed
     */
    @Override
    public void execute(Player player, World world) {
        if (!world.getAction(actionName).isAllowed(player) || world.getAction(actionName) == null){
            System.out.println("You can't perform that action.");
        } else {
            for (Effect effect : world.getAction(actionName).getEffects()) {
                effect.execute(player, world);
            }
        }
    }
}