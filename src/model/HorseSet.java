package model;

import java.util.ArrayList;

public class HorseSet {
	private int player;
	private int i;
	private int j;
	private ArrayList<Horse> horses = new ArrayList<Horse>();

	public HorseSet() {
		horses = null;
		i = -1;
		j = -1;
	}
	
	//horse�� �ϳ� ������ HorseSet ����
	//�Ű����� horse�� player ������ �ҷ��´�. horse ��ü ���� ������ player���� ó������� �� ������ �����ȴ�.
	public HorseSet(Horse horse) {
		player = horse.getPlayer();
		horses.add(horse);
		i = -1;
		j = -1;
	}
	
	//���ο� HorseSet�� ���� ��� -> player �� �� ������ �߰�(�� ����), �ٸ��� ��ü
	//ArrayList���� ��ü ������ ��� deep copy�� �Ͽ��� ���� ��ü�� �νĵǹǷ� ���� �����ڸ� ���� ��������� �Ѵ�.
	public void newHorseSet(HorseSet f) {
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
