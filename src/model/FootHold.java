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
		this.nextFootHold = null;
		this.prevFootHold = null;
		this.playerName = -1;
		this.horseNum = -1;
					
	}
	public void setNextFootHold(FootHold next) {
		this.nextFootHold = next;
	}
	public void setPrevFootHold(FootHold prev) {
		this.prevFootHold = prev;
	}
	public void putHorse(int playerName) {
		//현재 플레이어 이름이랑 들어온 이름이 다를때
		//같을때 
	}
}
