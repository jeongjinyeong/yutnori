package model;

public class FootHold {
	private int playerName;
	private int horseNum;
	private FootHold nextFootHold;
	private FootHold prevFootHold;
	
	public FootHold(FootHold previous) {
		this.prevFootHold = previous;
		previous.nextFootHold = this;
		this.playerName = -1;
		this.horseNum = -1;
	}
	
	public FootHold() {
		nextFootHold = null;
		prevFootHold = null;
		playerName = -1;
		horseNum = -1;
	}

	public void setNextFootHold(FootHold next) {
		nextFootHold = next;
	}
	public void setPrevFootHold(FootHold prev) {
		prevFootHold = prev;
	}
	
	public void putHorse(int playerName) {
		//현재 플레이어 이름이랑 들어온 이름이 다를때
		if(playerName != this.playerName) {
			this.playerName = playerName;
			horseNum = 1;
		}
		//같을때 
		else {
			horseNum++;
		}
	}
	
	public int getPlayerName() {
		return this.playerName;
	}
	
	public int getHorseNum() {
		return this.horseNum;
	}
	
	public FootHold getPrevFootHold() {
		return this.prevFootHold;
	}
	
	public FootHold getNextFootHold() {
		return this.nextFootHold;
	}
}
