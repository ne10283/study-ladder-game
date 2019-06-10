package com.nhnglobal.study.lunch.core.model;

import java.util.List;

public class GameRequest {
	
	private List<String> participants;
	
	private Integer winner;

	private GameRequest() {
	}
	
	public List<String> getParticipants() {
		return participants;
	}

	private void setParticipants(List<String> participants) {
		this.participants = participants;
	}

	public Integer getWinner() {
		return winner;
	}

	private void setWinner(Integer winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "GameRequest [participants=" + participants + ", winner=" + winner + "]";
	}	

}
