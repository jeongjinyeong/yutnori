package model;

public class Horse {
	private int player;
//	private int i;
//	private int j;
	
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
