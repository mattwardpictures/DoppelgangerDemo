package com.facextest.DoppelgangerDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceWrapper {

	private Emotion emotion;

	public FaceWrapper() {

	}

	public FaceWrapper(Emotion emotion) {
		super();
		this.emotion = emotion;
	}

	public Emotion getEmotion() {
		return emotion;
	}

	public void setEmotion(Emotion emotion) {
		this.emotion = emotion;
	}

	@Override
	public String toString() {
		return "FaceWrapper [emotion=" + emotion + "]";
	}

}
