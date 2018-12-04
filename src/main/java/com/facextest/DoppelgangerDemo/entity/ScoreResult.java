package com.facextest.DoppelgangerDemo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreResult {

	private List<Emotion> score;

	public ScoreResult() {

	}

	public ScoreResult(List<Emotion> score) {
		super();
		this.score = score;
	}

	public List<Emotion> getScore() {
		return score;
	}

	public void setScore(List<Emotion> score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ScoreResult [scores=" + score + "]";
	}

}
