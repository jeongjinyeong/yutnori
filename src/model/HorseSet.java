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
	
	//horse를 하나 가지고 HorseSet 생성
	//매개변수 horse의 player 정보를 불러온다. horse 객체 생성 제한은 player에서 처리해줘야 할 것으로 생각된다.
	public HorseSet(Horse horse) {
		player = horse.getPlayer();
		horses.add(horse);
		i = -1;
		j = -1;
	}
	
	//새로운 HorseSet이 들어올 경우 -> player 비교 후 같으면 추가(말 업기), 다르면 교체
	//ArrayList에서 객체 복사의 경우 deep copy를 하여도 같은 객체로 인식되므로 복사 생성자를 통해 복사해줘야 한다.
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
	
	//인덱스 값을 반환해 board에서 위치 이동
	public int get_i() {
		return i; 
	}
	
	public int get_j() {
		return j; 
	}
}
