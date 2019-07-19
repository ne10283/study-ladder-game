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
		if(mark == null) {
			this.mark = new Integer[2];
			this.mark[0] = x;
			this.mark[1] = y;
			repaint();
		}else {
			int x0 = this.mark[0];
			int y0 = this.mark[1];
			while(x0!=x || y0!=y) {
				if (x0 > x) x0--;
				else if (x0 < x) x0++;

				if (y0 > y) y0--;
				else if (y0 < y) y0++;

				this.mark[0] = x0;
				this.mark[1] = y0;

				try {
					Thread.sleep(2);
				}catch(Exception e){
					e.printStackTrace();
				}
				repaint();
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g) ;
		for (LadderVertical line : this.verticalLines) {
			Integer[] p = line.getPoints();
			g.setColor(Color.black);
			g.drawLine(p[0], p[1], p[2], p[3]);
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
	
	public void animateMark(List<LadderPoint> points) {
		Runnable task = () -> {
			for(LadderPoint point : points) {
				setMark(point.getPositionX(), point.getPositionY());
				try {
					Thread.sleep(30);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		Thread thread = new Thread(task);
		thread.start();
	}
}