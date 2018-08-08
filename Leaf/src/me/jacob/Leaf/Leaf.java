package me.jacob.Leaf;

import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import me.jacob.Leaf.managers.KeyManager;
import me.jacob.Leaf.rooms.TitleScreen;

public class Leaf {

	private static Game game;
	private static JFrame frame;
	private static KeyManager keyManager;

	public static void main(String[] args) {
		frame = new JFrame("Leaf");

		// 16 * 70, 9 * 70
		double aspectRatio = 16.0 / 9.0;
		int width = 16 * 70;
		int height = (int) (1120.0 / aspectRatio);

		frame.setPreferredSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width / 2, height / 2));

		game = new Game(width, height);
		game.setCurrentRoom(new TitleScreen());

		frame.add(game);

		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);

		keyManager = new KeyManager();
		frame.addKeyListener((KeyListener) keyManager);

		frame.setVisible(true);

		game.gameLoop();
	}

	public static JFrame getJFrame() {
		return frame;
	}

	public static Game getGame() {
		return game;
	}

	public static KeyManager getKeyManager() {
		return keyManager;
	}

}