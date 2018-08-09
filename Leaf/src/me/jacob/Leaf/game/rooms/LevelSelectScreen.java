package me.jacob.Leaf.game.rooms;

import java.awt.Graphics2D;

import me.jacob.Leaf.Leaf;
import me.jacob.Leaf.engine.Room;

public class LevelSelectScreen extends Room {
	
	// TODO choose song
	// TODO choose difficulty (time reflects difficulty choice? hard mode is night, easy is day, etc?)
	// TODO choose instruments?
	
	@Override
	public void draw(Graphics2D g2) {

	}

	@Override
	public void update(double delta) {
		Leaf.getGame().setCurrentRoom(new BattleScreen());
	}

}
