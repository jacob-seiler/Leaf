package me.jacob.Leaf.rooms;

import java.awt.Graphics2D;

import me.jacob.Leaf.Leaf;

public class LevelSelectScreen extends Room {

    @Override
    public void draw(Graphics2D g2) {

    }

    @Override
    public void update(double delta) {
	Leaf.getGame().setCurrentRoom(new BattleScreen());
    }

}
