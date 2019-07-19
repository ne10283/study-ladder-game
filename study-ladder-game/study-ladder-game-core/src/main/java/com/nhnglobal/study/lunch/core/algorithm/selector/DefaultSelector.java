package com.nhnglobal.study.lunch.core.algorithm.selector;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.nhnglobal.study.lunch.core.algorithm.LadderAlgorithm;

public class DefaultSelector implements LadderAlgorithm {

	@Override
	public List<String> select(List<String> participants, Integer winner) {
		if (participants == null || participants.isEmpty() || winner == null) return Collections.emptyList();
		else if (participants.size() <= winner) return participants;

		List<Integer> selectedIndexes = new Random()
				.ints(0, participants.size())
				.boxed()
				.distinct()
				.limit(winner)
				.collect(Collectors.toList());
		return selectedIndexes.stream().map(idx -> participants.get(idx)).collect(Collectors.toList());
	}

}
