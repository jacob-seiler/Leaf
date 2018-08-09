package me.jacob.Leaf.engine;

import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Object extends JPanel {

	public abstract void draw(Graphics2D g2);

	public abstract void update(double delta);

	public abstract double getLocX();

	public abstract double getLocY();

}
