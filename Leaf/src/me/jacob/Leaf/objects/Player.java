package me.jacob.Leaf.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

@SuppressWarnings("serial")
public class Player extends Object {

	private int index;

	private double x;
	private double y;
	private double targetX;
	private double targetY;

	private PlayerControls controls;

	private Color color;

	public Player(int index, PlayerControls controls, Color color) {
		this.index = index;

		this.x = 0;
		this.y = 0;

		this.controls = controls;

		this.color = color;
	}

	public int getIndex() {
		return this.index;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(color);
		Rectangle2D.Double shape = new Rectangle2D.Double(x, y, 50, 50);
		g2.fill(shape);
	}

	@Override
	public void update(double delta) {
		x -= (x - targetX) * delta / 10;
		y -= (y - targetY) * delta / 10;
	}

	@Override
	public double getLocX() {
		return this.x;
	}

	@Override
	public double getLocY() {
		return this.y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setTargetX(double x) {
		this.targetX = x;
	}

	public void setTargetY(double y) {
		this.targetY = y;
	}

	public PlayerControls getControls() {
		return controls;
	}

	public Color getColor() {
		return color;
	}

}
