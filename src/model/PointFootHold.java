package model;

public class PointFootHold extends FootHold{
	private FootHold centerFootHold;

	public PointFootHold(FootHold prev) {
		super(prev);
		this.centerFootHold = null;
	}
	public void setCenterFootHold(FootHold toCenter) {
		centerFootHold = toCenter;
	}
}
