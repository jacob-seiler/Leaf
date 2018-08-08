package me.jacob.Leaf.objects;

import java.util.ArrayList;
import java.util.List;

public class PlayerControls {

	private List<Integer> keys;

	public PlayerControls(int key1, int key2, int key3, int key4, int key5) {
		keys = new ArrayList<Integer>();

		this.keys.add(key1);
		this.keys.add(key2);
		this.keys.add(key3);
		this.keys.add(key4);
		this.keys.add(key5);
	}

	public int getKey1() {
		return getKey(0);
	}

	public int getKey2() {
		return getKey(1);
	}

	public int getKey3() {
		return getKey(2);
	}

	public int getKey4() {
		return getKey(3);
	}

	public int getKey5() {
		return getKey(4);
	}

	public int getKey(int index) {
		return keys.get(index);
	}

	public List<Integer> getAllKeys() {
		return keys;
	}

}
