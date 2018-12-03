package com.facextest.DoppelgangerDemo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreResult {

	private List<Score> scores;

	public ScoreResult() {

	}

	public ScoreResult(List<Score> scores) {
		super();
		this.scores = scores;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "ScoreResult [scores=" + scores + "]";
	}

}
