package model;

public class Horse {
	private int player;
	//public static int num;
	//말의 최대 갯수에 맞춰서 객체 생성에 대한 조건을 생성해야 함.
	//Horse가 Player를 객체로 가질 것인가, Player가 Horse를 객체로 가질 것인가....
	//Player가 HorseSet을 객체로 가져야하나..?(유력)
	
	public Horse() {
		player = -1;
	}
	
	public Horse(Horse h) {
		this.player = h.getPlayer();
	}
	
	public Horse(int player) {
		this.player = player;
	}
	
	public int getPlayer() {
		return player;
	}
}