package model;

public class CenterFootHold extends FootHold{
	private FootHold rightDownFootHold;
	private FootHold leftDownFootHold;
	private FootHold leftUpFootHold;
	
	public CenterFootHold(FootHold prev) {
		super(prev);
		this.rightDownFootHold = null;
		this.leftDownFootHold= null;
		this.leftUpFootHold= null;
		
	}
	
}
