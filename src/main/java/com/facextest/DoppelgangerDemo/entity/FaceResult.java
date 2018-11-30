package com.facextest.DoppelgangerDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceResult {

	private double confidence;

	public FaceResult() {

	}

	public FaceResult(double confidence) {
		super();
		this.confidence = confidence;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	@Override
	public String toString() {
		return "FaceResult [confidence=" + confidence + "]";
	}

}
