package bcu.s17119577.adventure.effects;

import bcu.s17119577.adventure.model.Player;
import bcu.s17119577.adventure.model.World;

public interface Effect {
	public void execute(Player player, World world);
}
