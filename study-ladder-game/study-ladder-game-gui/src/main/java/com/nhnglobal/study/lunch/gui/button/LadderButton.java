package com.nhnglobal.study.lunch.gui.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.nhnglobal.study.lunch.gui.line.LadderVertical;
import com.nhnglobal.study.lunch.gui.line.LadderPoint;
import com.nhnglobal.study.lunch.gui.panel.LadderPanel;


public class LadderButton extends JButton {
	private LadderVertical startLine;
	private JPanel panel;
	
	public LadderButton(String btnName, LadderVertical line, LadderPanel panel) {
		super(btnName);
		this.startLine = line;
		this.panel = panel;
		
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				setMarkOnPanel();
				startLine.getGoalLine();
				panel.animateMark(startLine.getStopPoints());
            }
		});
	}
	
	public LadderVertical getStartLine() {
		return this.startLine;
	}
	
	private void setMarkOnPanel() {
		((LadderPanel) this.panel).setMark(
				startLine.getGoalLine().getPositionX(), 
				startLine.getGoalLine().getPositionY() + startLine.getGoalLine().getLength());
	}
}


