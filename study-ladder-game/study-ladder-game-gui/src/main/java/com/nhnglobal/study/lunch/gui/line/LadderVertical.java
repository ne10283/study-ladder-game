package com.nhnglobal.study.lunch.gui.line;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

public class LadderVertical {
	private int length;
	private int positionX;
	private int positionY;
	private List<LadderHorizontal> horizontalLines;
	private List<LadderPoint> stopPoints;
	
	public LadderVertical(int length, int x, int y) {
		this.length = length;
		this.positionX = x;
		this.positionY = y;
		this.horizontalLines = new ArrayList<>();
		this.stopPoints = new ArrayList<>();
	}
	
	public void setLength(int l) {
		this.length = l;
	}
	public int getLength() {
		return this.length;
	}
	public void setPositionX(int x) {
		this.positionX = x;
	}
	public int getPositionX() {
		return this.positionX;
	}
	public void setPositionY(int y) {
		this.positionY = y;
	}
	public int getPositionY() {
		return this.positionY;
	}
	public void addHorizontalLine(LadderHorizontal horizontalLine) {
		this.horizontalLines.add(horizontalLine);
	}
	public List<LadderHorizontal> getHorizontalLines() {
		return this.horizontalLines;
	}
	
	public Integer[] getPoints() {
		Integer[] points = new Integer[4];
		points[0] = this.positionX;
		points[1] = this.positionY;
		points[2] = this.positionX;
		points[3] = this.positionY + this.length;
		return points;
	}
	
	public LadderHorizontal getNextHorizontalLine(double min) {
		Optional<LadderHorizontal> next = this.getHorizontalLines()
				.stream()
				.filter(x -> x.getPosition() > min)
				.min(Comparator.comparing(LadderHorizontal::getPosition));
        return next.orElse(null);
	}
	
	public LadderVertical getGoalLine() {
		double minPosition = 0.0;
		this.stopPoints = new ArrayList<>();
		LadderVertical currentLine = this;
		this.stopPoints.add(new LadderPoint(currentLine.getPositionX(), currentLine.getPositionY()));
		
		while(currentLine.getNextHorizontalLine(minPosition) != null) {
			LadderHorizontal hLine = currentLine.getNextHorizontalLine(minPosition);
			
			this.stopPoints.add(new LadderPoint(currentLine.getPositionX(), hLine.getPoints()[1]));
			
			minPosition = hLine.getPosition();
			currentLine = hLine.getOtherLine(currentLine);
			
			this.stopPoints.add(new LadderPoint(currentLine.getPositionX(), hLine.getPoints()[1]));
		}
		
		this.stopPoints.add(new LadderPoint(currentLine.getPositionX(), currentLine.getPositionY() + currentLine.getLength()));
		return currentLine;
	}
	
	public List<LadderPoint> getStopPoints() {
		return this.stopPoints;
	}
}
