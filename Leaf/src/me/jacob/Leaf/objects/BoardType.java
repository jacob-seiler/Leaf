package me.jacob.Leaf.objects;

import java.awt.Color;

public enum BoardType {
	GUITAR(new Color(195, 165, 95), 6), BASS(new Color(90, 90, 90), 4), SAXOPHONE(new Color(240, 210, 125), 4),
	DRUMS(new Color(155, 155, 155), 5);

	private Color c;
	private int lines;

	BoardType(Color c, int lines) {
		this.c = c;
		this.lines = lines;
	}

	public Color getColor() {
		return c;
	}

	public int getLines() {
		return lines;
	}

}