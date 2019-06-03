package com.nhnglobal.study.lunch.core.algorithm.selector;

import java.util.ArrayList;
import java.util.List;

import com.nhnglobal.study.lunch.core.algorithm.LadderAlgorithm;

public class BrianSelector implements LadderAlgorithm {

	@Override
	public List<String> select(List<String> participants, Integer winner) {
		
		List<String> winners = new ArrayList<String>();
		for(int i = 0; i < winner; i++) {
			winners.add("brian");
		}
		return winners;
	}

}
