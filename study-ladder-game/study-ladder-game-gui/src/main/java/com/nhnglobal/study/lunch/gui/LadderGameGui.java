package com.nhnglobal.study.lunch.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;

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
	private final int HORIZONTAL_LINES = 3;
	
	public void createFrame() {
		JFrame.setDefaultLookAndFeelDecorated(true);
	    frame = new JFrame("Ladder Game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBackground(Color.white);
	    frame.setSize(1000, 600);
	    
	    panel = new LadderPanel();
	}
	
	public void addParticipants(List<String> participantList) {
		if (participantList == null || participantList.isEmpty())
			return;

		int left = 100;
		boolean isFirst = true;
		LadderVertical prevHorizontalLine = null;

		for (String participant : participantList) {
			LadderVertical currentVerticalLine = new LadderVertical(400, left, 50);
			panel.addVerticalLine(currentVerticalLine);

			if (isFirst)
				isFirst = false;
			else
				panel.addHorizontalLines(this.generateHorizontalLines(prevHorizontalLine, currentVerticalLine));
			
			LadderButton button = new LadderButton(participant, currentVerticalLine, panel);
			button.setBounds(50, 50, left, 50);
			panel.add(button);
			
			left += 100;
			prevHorizontalLine = currentVerticalLine;
		}
	}

	private List<LadderHorizontal> generateHorizontalLines(LadderVertical prevLine, LadderVertical verticalLine) {
		Random generator = new Random();
		List<LadderHorizontal> generatedHorizontalLineList = new ArrayList<>();

		for (int i = 0; i < HORIZONTAL_LINES; i++) {
			double ratio = (double) generator.nextInt(1000) / 1000;
			generatedHorizontalLineList.add(new LadderHorizontal(prevLine, verticalLine, ratio));
		}

		return generatedHorizontalLineList;
	}

	private void generateWinners(List<String> participantList, Integer noOfWinner) {
		if (participantList == null || participantList.isEmpty() || noOfWinner == null || noOfWinner == 0)
			return;

		List<Integer> selectedIndexList = new Random()
				.ints(0, participantList.size())
				.boxed()
				.distinct()
				.limit(noOfWinner)
				.collect(Collectors.toList());

		List<LadderVertical> verticalLineList = this.panel.getVerticalLines();
		for (Integer index : selectedIndexList) {
			verticalLineList.get(index).setWinnerPoint();
		}
	}

	private void startFrame() {
		frame.add(panel);
		frame.setVisible(true);
	}

	public void execute(List<String> participantList, Integer noOfWinner) {
		this.createFrame();
		this.addParticipants(participantList);
		this.generateWinners(participantList, noOfWinner);
		this.startFrame();
	}
}