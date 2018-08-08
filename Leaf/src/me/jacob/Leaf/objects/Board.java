package me.jacob.Leaf.objects;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class Board extends Object {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private BoardType type;
	
	private Player controller;
	
	public Board(int x, BoardType type) {
		this.x = x;
		this.y = 225;
		this.width = 225;
		this.height = 630;
		this.type = type;
	}
	
	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(type.getColor());
		g2.fillRect(x, y, width, height);

		if (controller != null) {
			g2.setColor(controller.getColor());
			g2.setStroke(new BasicStroke(10));
			g2.drawRect(x, y, width, height);
		}
	}
	
	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public double getLocX() {
		return x;
	}
	
	@Override
	public double getLocY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public BoardType getBoardType() {
		return type;
	}
	
	public void setController(Player player) {
		this.controller = player;
	}
	
	public Player getController() {
		return this.controller;
	}
	
}
