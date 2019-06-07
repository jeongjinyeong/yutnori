package model;

import java.util.ArrayList;

public class HorseSet {
	private int player;
	private int i;
	private int j;
	private ArrayList<Horse> horses = new ArrayList<Horse>();

	public HorseSet() {}
	
	public HorseSet(int player) {
		this.player = player;
		this.i = -1;
		this.j = -1;
	}
	
	public HorseSet(int player, int i, int j) {
		this.player = player;
		this.i = i;
		this.j = j;
	}
	
	public HorseSet(int player, Horse horse) {
		this.player = player;
		horses.add(horse);
		i = -1;
		j = -1;
	}
	
//	���ο� HorseSet�� ���� ��� -> player �� �� ������ �߰�(�� ����), �ٸ��� ��ü
//	ArrayList���� ��ü ������ ��� deep copy�� �Ͽ��� ���� ��ü�� �νĵǹǷ� ���� �����ڸ� ���� ��������� �Ѵ�.
	public void newHorse(HorseSet f) {
		if(player==f.getPlayer()) {
			for(int i=0; i<f.getHorses().size() ;i++) {
				horses.add(new Horse(f.getHorses().get(i)));
			}
		}
		else {
			player = f.getPlayer();
			horses.clear();
			for(int i=0; i<f.getHorses().size() ;i++) {
				horses.add(new Horse(f.getHorses().get(i)));
			}
		}
	}

	public void setIndex(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public int getPlayer() {
		return this.player;
	}
	
	public ArrayList<Horse> getHorses() {
		return this.horses;
	}
	
	//�ε��� ���� ��ȯ�� board���� ��ġ �̵�
	public int get_i() {
		return i; 
	}
	
	public int get_j() {
		return j; 
	}
}
