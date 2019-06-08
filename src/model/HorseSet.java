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
	
	public HorseSet(HorseSet horseSet) {
		this.player = horseSet.getPlayer();
		horses = horseSet.getHorses();
		i = horseSet.get_i();
		j = horseSet.get_j();
	}

	//현재 HorseSet에 새로운 HorseSet이 들어온 경우 플레이어 비교 후 처리
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

	public void putHorse(Horse horse) {
		this.horses.add(horse);
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
	
	public int get_i() {
		return i; 
	}
	
	public int get_j() {
		return j; 
	}
}
