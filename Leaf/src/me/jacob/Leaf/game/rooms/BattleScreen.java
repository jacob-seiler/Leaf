package me.jacob.Leaf.game.rooms;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jacob.Leaf.Leaf;
import me.jacob.Leaf.engine.Room;
import me.jacob.Leaf.game.managers.BoardManager;
import me.jacob.Leaf.game.objects.Board;
import me.jacob.Leaf.game.objects.Player;

public class BattleScreen extends Room {

	private BoardManager boardManager;

	public BattleScreen() {
		boardManager = new BoardManager();

		Player p1 = Leaf.getGame().getPlayerManager().getPlayer1();
		p1.setX(560);
		setBoard(p1, getBoardManager().getBoards().get(0));

		Player p2 = Leaf.getGame().getPlayerManager().getPlayer2();
		p2.setX(560);
		setBoard(p2, getBoardManager().getBoards().get(2));
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, 16 * 70, 9 * 70);
		getBoardManager().draw(g2);

		for (Player p : Leaf.getGame().getPlayerManager().getPlayers()) {
			p.draw(g2);
		}
	}

	@Override
	public void update(double delta) {
		// double speed = 1 * delta / 10;
		//
		// x += speed;
		// y += speed;

		getBoardManager().updateBoards(delta);

		for (Player p : Leaf.getGame().getPlayerManager().getPlayers()) {
			p.update(delta);

			if (Leaf.getKeyManager().isKeyPressedOnce(p.getControls().getKey5()))
				switchBoard(p);
		}
	}

	private void switchBoard(Player p) {
		int currentBoard = 0;

		for (int i = 0; i < getBoardManager().getBoards().size(); i++)
			if (getBoardManager().getBoards().get(i).getController() == p)
				currentBoard = i;

		getBoardManager().getBoards().get(currentBoard).setController(null);

		int newBoard = currentBoard + 1;
		if (newBoard >= 4)
			newBoard = 0;

		if (getBoardManager().getBoards().get(newBoard).getController() != null) {
			newBoard++;
			if (newBoard >= 4)
				newBoard = 0;
		}

		setBoard(p, getBoardManager().getBoards().get(newBoard));
	}

	private void setBoard(Player p, Board b) {
		b.setController(p);
		p.setTargetX(b.getLocX() - 25 + b.getWidth() / 2);
	}

	private BoardManager getBoardManager() {
		return boardManager;
	}

}
