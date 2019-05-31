package model;

public class Player {
	private int name; // 플레이어의 이름 1,2,3,4 숫자로 이루어짐 
	private int horseNum; //전체 말의 갯수
	private int waitHorse; // 대기중인 말갯수
	private int finishHorse; // 도착한 말의 갯수
	private int throwNum; // 던질수 있는 기회
	private int[] yutResults; //던진결과들의 배열 
	
	public  Player(int _name, int _horseNum ) {
		this.name = _name;
		this.horseNum = _horseNum;
		this.waitHorse = _horseNum;
		this.finishHorse = 0;
		this.throwNum = 0;
		
	}
	public int gethorseNum() {
		return this.horseNum;
	}
	public int getWaittingHorse() {
		return this.waitHorse;
	}
	public int getFinishedHorse() {
		return this.finishHorse;
	}
	public int getThrowNum() {
		return this.throwNum;
	}
	public void setThrowNum(int setNum) {
		this.throwNum = setNum;
	}
	public void addThrowNum() {
		this.throwNum++;
	}
	public void delThrowNum() {
		this.throwNum--;
	}
}
