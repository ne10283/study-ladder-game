package com.nhnglobal.study.lunch.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nhnglobal.study.lunch.gui.panel.LadderPanel;
import com.nhnglobal.study.lunch.gui.button.LadderButton;
import com.nhnglobal.study.lunch.gui.line.LadderVertical;
import com.nhnglobal.study.lunch.gui.line.LadderHorizontal;

public class LadderGameGui {
	private static Logger log = LoggerFactory.getLogger(LadderGameGui.class);
	private JFrame frame;
	private LadderPanel panel;
	
	public void createFrame() {
		JFrame.setDefaultLookAndFeelDecorated(true);
	    frame = new JFrame("Ladder Game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBackground(Color.white);
	    frame.setSize(1000, 600);
	    
	    panel = new LadderPanel();
	}
	
	public void addParticipants(List<String> list) {
		int left = 100;
		boolean isFirst = true;
		LadderVertical prevLine = null;
		Random generator = new Random();
		for(String word : list) {
			LadderVertical verticalLine = new LadderVertical(400, left, 50);
			if (!isFirst) {
				for(int i = 0; i < 3; i++) {
					double ratio = (double)generator.nextInt(1000) / 1000;
					LadderHorizontal horizontalLine = new LadderHorizontal(prevLine, verticalLine, ratio);
					panel.addHorizontalLine(horizontalLine);
				}
			}
			else isFirst = false;
			panel.addVerticalLine(verticalLine);
			
			LadderButton button = new LadderButton(word, verticalLine, panel);
			button.setBounds(50, 50, left, 50);
			panel.add(button);
			
			left += 100;
			prevLine = verticalLine;
		}
	}
	
	public void startFrame() {
		frame.add(panel);
		frame.setVisible(true);
	}
}