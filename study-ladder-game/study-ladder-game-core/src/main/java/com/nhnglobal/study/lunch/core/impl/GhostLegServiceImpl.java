package com.nhnglobal.study.lunch.core.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nhnglobal.study.lunch.core.GhostLegService;
import com.nhnglobal.study.lunch.core.algorithm.LadderAlgorithm;
import com.nhnglobal.study.lunch.core.model.GameRequest;
import com.nhnglobal.study.lunch.core.algorithm.selector.DefaultSelector;

public class GhostLegServiceImpl implements GhostLegService {

	private LadderAlgorithm ladderAlgorithm;
	
	public GhostLegServiceImpl() {
		this.ladderAlgorithm = new DefaultSelector();
	}
	
	public GhostLegServiceImpl(LadderAlgorithm ladderAlgorithm) {
		this.ladderAlgorithm = ladderAlgorithm; 
	}

	@Override
	public List<String> bet(GameRequest request) {
		List<String> winners = ladderAlgorithm.select(request.getParticipants(), request.getWinner());
		return Optional.ofNullable(winners).orElse(new ArrayList<String>());
	}
}
