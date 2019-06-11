package com.nhnglobal.study.lunch.core.algorithm.selector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nhnglobal.study.lunch.core.algorithm.LadderAlgorithm;

public class DefaultSelector implements LadderAlgorithm {

	@Override
	public List<String> select(List<String> participants, Integer winner) {
		Random generator = new Random();
		List<String> winners = new ArrayList<String>();
		for(int i = 0; i < winner; i++) {
			int idx = generator.nextInt(participants.size());
			String randomWinner = participants.get(idx);
			winners.add(randomWinner);
			participants.remove(idx);
		}
		return winners;
	}

}
