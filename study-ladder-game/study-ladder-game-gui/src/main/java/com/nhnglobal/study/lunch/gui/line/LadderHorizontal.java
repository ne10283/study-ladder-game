package com.nhnglobal.study.lunch.gui.line;

public class LadderHorizontal {
	private LadderVertical left;
	private LadderVertical right;
	private double position;
	
	public LadderHorizontal(LadderVertical l, LadderVertical r, double p) {
		this.left = l;
		this.right = r;
		this.position = p;
		
		this.left.addHorizontalLine(this);
		this.right.addHorizontalLine(this);
	}
	
	public double getPosition() {
		return this.position;
	}
	
	public Integer[] getPoints() {
		Integer[] points = new Integer[4];
		points[0] = left.getPositionX();
		points[1] = left.getPositionY() + (int)(left.getLength() * this.position);
		points[2] = right.getPositionX();
		points[3] = left.getPositionY() + (int)(left.getLength() * this.position);
		return points;
	}
	
	public LadderVertical getOtherLine(LadderVertical line) {
		if (line == this.left) return this.right;
		else return this.left;
	}
}
