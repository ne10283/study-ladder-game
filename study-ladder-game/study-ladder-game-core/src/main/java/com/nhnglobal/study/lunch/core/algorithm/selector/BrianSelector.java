package com.nhnglobal.study.lunch.core.algorithm.selector;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.nhnglobal.study.lunch.core.algorithm.LadderAlgorithm;

public class BrianSelector implements LadderAlgorithm {

	private static final String BRIAN = "brian";

	@Override
	public List<String> select(List<String> participants, Integer winner) {

		if (Objects.isNull(winner) || winner <= 0)
			return Collections.emptyList();

		if (winner >= participants.size())
			return Collections.nCopies(participants.size(), BRIAN);

		return Collections.nCopies(winner, BRIAN);
	}

}
