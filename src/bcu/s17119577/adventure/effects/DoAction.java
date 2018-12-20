package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Action;
import bcu.s17119577.adventure.model.Item;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class DoAction implements Effect{
    private String actionName;

    public DoAction(String name) {
        this.actionName = name;
    }

    @Override
    public void execute(Player player, World world) {
        if (!world.getAction(actionName).isAllowed(player) || world.getAction(actionName) == null){
            System.out.println("You cant perform that action.");
        } else {
            for (Effect effect : world.getAction(actionName).getEffects()){
                effect.execute(player, world);
            }
        }
    }
}