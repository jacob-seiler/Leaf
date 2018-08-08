package me.jacob.Leaf;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import me.jacob.Leaf.managers.DisplayManager;
import me.jacob.Leaf.managers.PlayerManager;
import me.jacob.Leaf.rooms.Room;

@SuppressWarnings("serial")
public class Game extends JPanel {

	private static Room currentRoom;

	private PlayerManager playerManager;

	private DisplayManager displayManager;

	private static boolean isRunning;

	private int width;
	private int height;

	public Game(int width, int height) {
		this.width = width;
		this.height = height;

		isRunning = true;
		playerManager = new PlayerManager();
		displayManager = new DisplayManager();
	}

	public void gameLoop() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;

		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				tick(delta * (60 / amountOfTicks));
				updates++;
				delta--;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	private void tick(double delta) {
		getCurrentRoom().update(delta);
	}

	private void render() {
		repaint();
	}

	// OTHER FUNCTIONS

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room room) {
		currentRoom = room;
	}

	public PlayerManager getPlayerManager() {
		return playerManager;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		displayManager.scaleScreen(g2, width, height);
		currentRoom.draw(g2);
		displayManager.drawBars(g2, width, height);
	}
}