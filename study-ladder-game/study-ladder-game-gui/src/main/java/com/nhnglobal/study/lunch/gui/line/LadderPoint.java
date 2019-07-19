package com.nhnglobal.study.lunch.gui.line;

public class LadderPoint {
	private int positionX;
	private int positionY;
	
	public LadderPoint(int x, int y) {
		positionX = x;
		positionY = y;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public String toString() {
		return "x: " + this.positionX + ", y: " + this.positionY;
	}
}