package me.jacob.Leaf.managers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import me.jacob.Leaf.Leaf;

public class DisplayManager {

    private double scaleX;
    private double scaleY;

    private AffineTransform vanilla;
    private AffineTransform scaled;

    public DisplayManager() {
	this.scaleX = 1;
	this.scaleY = 1;

	this.vanilla = null;
    }

    public void scaleScreen(Graphics2D g2, double width, double height) {
	reset(g2);

	vanilla = g2.getTransform();

	g2.setBackground(new Color(0, 0, 0));
	g2.setColor(new Color(0, 0, 0));
	g2.fillRect(0, 0, Leaf.getJFrame().getWidth(), Leaf.getJFrame().getHeight());

	calculateScale(g2, width, height);

	g2.setTransform(scaled);
    }

    private void calculateScale(Graphics2D g2, double width, double height) {
	scaled = g2.getTransform();

	if (!Leaf.getJFrame().isUndecorated())
	    scaled.translate(0, -28);

	scaleX = Leaf.getJFrame().getSize().getWidth() / width;
	scaleY = Leaf.getJFrame().getSize().getHeight() / height;

	if (scaleX < scaleY) {
	    double translateAmount = (Leaf.getJFrame().getSize().getHeight() - height * scaleX) / 2;
	    scaled.translate(0, translateAmount);
	    scaled.scale(scaleX, scaleX);
	} else if (scaleY < scaleX) {
	    // TODO fix snap maybe
	    double scaleValue = Leaf.getJFrame().getSize().getHeight() / (height - 12);
	    double translateAmount = (Leaf.getJFrame().getSize().getWidth() - width * scaleValue) / 2;

	    scaled.translate(translateAmount, 0);
	    scaled.scale(scaleY, scaleY);
	} else
	    scaled.scale(scaleX, scaleY);
    }

    public void drawBars(Graphics2D g2, double width, double height) {
	reset(g2);
	g2.setColor(new Color(0, 0, 0, 255));

	int extra = 2;

	Rectangle2D top = new Rectangle2D.Double(0, -extra / 2, Leaf.getJFrame().getWidth(),
		(Leaf.getJFrame().getSize().getHeight() - height * scaleX) / 2 - 28);
	Rectangle2D bottom = new Rectangle2D.Double(0,
		(Leaf.getJFrame().getSize().getHeight() + height * scaleX) / 2 - 28 + extra / 2,
		Leaf.getJFrame().getWidth(), Leaf.getJFrame().getHeight() * scaleX);

	double scaleValue = Leaf.getJFrame().getSize().getHeight() / (height - 12);
	double size = Leaf.getJFrame().getWidth() * scaleY;
	Rectangle2D left = new Rectangle2D.Double(
		(Leaf.getJFrame().getSize().getWidth() - width * scaleValue) / 2 - size - extra / 2, 0, size,
		Leaf.getJFrame().getHeight());
	Rectangle2D right = new Rectangle2D.Double(
		(Leaf.getJFrame().getSize().getWidth() - width * scaleValue) / 2 + (width * scaleY) + extra / 2, 0,
		size, Leaf.getJFrame().getHeight());

	g2.fill(top);
	g2.fill(bottom);
	g2.fill(left);
	g2.fill(right);

	g2.setTransform(scaled);
    }

    public void reset(Graphics2D g2) {
	if (vanilla != null)
	    g2.setTransform(vanilla);
    }

}
