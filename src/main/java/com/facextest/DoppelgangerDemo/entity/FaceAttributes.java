package com.facextest.DoppelgangerDemo.entity;

public class FaceAttributes {

	private Emotion emotion;

	public FaceAttributes() {
		// TODO Auto-generated constructor stub
	}

	public FaceAttributes(Emotion emotion) {
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
		return "FaceAttributes [emotion=" + emotion + "]";
	}

}
