package com.nhnglobal.study.lunch.gui.panel;

import java.awt.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;
import com.nhnglobal.study.lunch.gui.line.LadderVertical;
import com.nhnglobal.study.lunch.gui.line.LadderHorizontal;
import com.nhnglobal.study.lunch.gui.line.LadderPoint;

public class LadderPanel extends JPanel {
	private List<LadderVertical> verticalLines; 
	private List<LadderHorizontal> horizontalLines;
	private Integer[] mark;
	
	public LadderPanel() {
		verticalLines = new ArrayList<>();
		horizontalLines = new ArrayList<>();
	}
	
	public void setMark(int x, int y) {
		if (mark == null) this.mark = new Integer[2];
		this.mark[0] = x;
		this.mark[1] = y;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g) ;
		for (LadderVertical line : this.verticalLines) {
			Integer[] p = line.getPoints();
			g.setColor(Color.black);
			g.drawLine(p[0], p[1], p[2], p[3]);
			if (line.getIsWinnerPoint())
				g.drawString("Winner", p[2] - 15, p[3] + 20);
		}
		for (LadderHorizontal line : this.horizontalLines) {
			Integer[] p = line.getPoints();
			g.setColor(Color.black);
			g.drawLine(p[0], p[1], p[2], p[3]);
		}
		
		if (mark != null) {
			g.setColor(Color.red);
			g.fillOval(mark[0] - 5, mark[1] - 5, 10, 10);
		}
	}
	
	public void addVerticalLine(LadderVertical line) {
		this.verticalLines.add(line);
	}
	
	public void addHorizontalLine(LadderHorizontal line) {
		this.horizontalLines.add(line);
	}

	public void addHorizontalLines(List<LadderHorizontal> lines) {
		this.horizontalLines.addAll(lines);
	}

	public List<LadderVertical> getVerticalLines() {
		return this.verticalLines;
	}
	
	public void animateMark(List<LadderPoint> points) {
		Runnable task = () -> {
			for(LadderPoint point : points) {
				setMark(point.getPositionX(), point.getPositionY());
				try {
					Thread.sleep(300);	
				}
				catch(Exception ex) {
					
				}
			}
		};
		Thread thread = new Thread(task);
		thread.start();
	}
}