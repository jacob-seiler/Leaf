package me.jacob.Leaf.game.managers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import me.jacob.Leaf.game.objects.Board;
import me.jacob.Leaf.game.objects.BoardType;

public class BoardManager {

	private List<Board> boards;

	public BoardManager() {
		boards = new ArrayList<Board>();

		int x = 44;
		int padding = 269;

		boards.add(new Board(x, BoardType.GUITAR));
		boards.add(new Board(x + padding, BoardType.SAXOPHONE));
		boards.add(new Board(x + (padding * 2), BoardType.DRUMS));
		boards.add(new Board(x + (padding * 3), BoardType.BASS));
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void updateBoards(double delta) {
		for (Board b : getBoards())
			b.update(delta);
	}

	public void draw(Graphics2D g2) {
		for (Board b : getBoards())
			b.draw(g2);
	}

}
