package me.jacob.Leaf.game.rooms;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jacob.Leaf.Leaf;
import me.jacob.Leaf.engine.Room;
import me.jacob.Leaf.game.objects.Player;

public class TitleScreen extends Room {
	
	// TODO display something
	// TODO loading screen while images are loading?
	// TODO press any key to start, then listen for each player's input
	
	// private double x = 0;
	// private double y = 0;

	private boolean p1Ready;
	private boolean p2Ready;

	public TitleScreen() {
		p1Ready = false;
		p2Ready = false;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(Color.WHITE);
		g2.drawString("TITLE SCREEN", 50, 50);
		g2.drawString("P1 Ready: " + p1Ready, 50, 65);
		g2.drawString("P2 Ready: " + p2Ready, 50, 80);
	}

	@Override
	public void update(double delta) {
		for (Player p : Leaf.getGame().getPlayerManager().getPlayers())
			for (int i : p.getControls().getAllKeys())
				if (Leaf.getKeyManager().isKeyPressed(i))
					if (p.getIndex() == 0)
						p1Ready = true;
					else
						p2Ready = true;

		if (p1Ready && p2Ready)
			Leaf.getGame().setCurrentRoom(new LevelSelectScreen());
	}

}
