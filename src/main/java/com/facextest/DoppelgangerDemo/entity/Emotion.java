package com.facextest.DoppelgangerDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Emotion {

	private double contempt;
	private double surprise;
	private double happiness;
	private double neutral;
	private double sadness;
	private double disgust;
	private double anger;
	private double fear;

	public Emotion() {

	}

	public Emotion(double contempt, double surprise, double happiness, double neutral, double sadness, double disgust,
			double anger, double fear) {
		super();
		this.contempt = contempt;
		this.surprise = surprise;
		this.happiness = happiness;
		this.neutral = neutral;
		this.sadness = sadness;
		this.disgust = disgust;
		this.anger = anger;
		this.fear = fear;
	}

	public double getContempt() {
		return contempt;
	}

	public void setContempt(double contempt) {
		this.contempt = contempt;
	}

	public double getSurprise() {
		return surprise;
	}

	public void setSurprise(double surprise) {
		this.surprise = surprise;
	}

	public double getHappiness() {
		return happiness;
	}

	public void setHappiness(double happiness) {
		this.happiness = happiness;
	}

	public double getNeutral() {
		return neutral;
	}

	public void setNeutral(double neutral) {
		this.neutral = neutral;
	}

	public double getSadness() {
		return sadness;
	}

	public void setSadness(double sadness) {
		this.sadness = sadness;
	}

	public double getDisgust() {
		return disgust;
	}

	public void setDisgust(double disgust) {
		this.disgust = disgust;
	}

	public double getAnger() {
		return anger;
	}

	public void setAnger(double anger) {
		this.anger = anger;
	}

	public double getFear() {
		return fear;
	}

	public void setFear(double fear) {
		this.fear = fear;
	}

	@Override
	public String toString() {
		return "Emotion [contempt=" + contempt + ", surprise=" + surprise + ", happiness=" + happiness + ", neutral="
				+ neutral + ", sadness=" + sadness + ", disgust=" + disgust + ", anger=" + anger + ", fear=" + fear
				+ "]";
	}

}
