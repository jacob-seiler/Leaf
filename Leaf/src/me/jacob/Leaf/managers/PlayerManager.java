package me.jacob.Leaf.managers;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

import me.jacob.Leaf.objects.Player;
import me.jacob.Leaf.objects.PlayerControls;

public class PlayerManager {

	private Player player1;
	private Player player2;

	public PlayerManager() {
		// Player 1
		PlayerControls p1Controls = new PlayerControls(KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_A, KeyEvent.VK_W,
				KeyEvent.VK_Q);
		Color p1Color = new Color(125, 220, 105);
		player1 = new Player(0, p1Controls, p1Color);

		// Player 2
		PlayerControls p2Controls = new PlayerControls(KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT,
				KeyEvent.VK_UP, KeyEvent.VK_SPACE);
		Color p2Color = new Color(220, 110, 55);
		player2 = new Player(1, p2Controls, p2Color);
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public List<Player> getPlayers() {
		return Arrays.asList(player1, player2);
	}

}
