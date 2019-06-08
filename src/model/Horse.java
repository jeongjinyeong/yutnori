package model;

public class Horse {
	private int player;
	
	public Horse() {}
	
	public Horse(int player) {
		this.player = player;
	}
	
	public Horse(Horse h) {
		player = h.getPlayer();
	}
	
	public int getPlayer() {
		return this.player;
	}
}
