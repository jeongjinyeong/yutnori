package model;

public class Horse {
	private int player;
	//public static int num;
	//���� �ִ� ������ ���缭 ��ü ������ ���� ������ �����ؾ� ��.
	//Horse�� Player�� ��ü�� ���� ���ΰ�, Player�� Horse�� ��ü�� ���� ���ΰ�....
	//Player�� HorseSet�� ��ü�� �������ϳ�..?(����)
	
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