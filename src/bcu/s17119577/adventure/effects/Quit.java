package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.game.QuitException;
import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public class Quit implements Effect{

    public Quit() {
    }

    @Override
    public void execute(Player player, World world) {
        throw new QuitException();
    }
}