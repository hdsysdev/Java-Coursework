package bcu.changeme.adventure.effects;

import bcu.changeme.adventure.model.Player;
import bcu.changeme.adventure.model.World;

public interface Effect {
	public void execute(Player player, World world);
}
