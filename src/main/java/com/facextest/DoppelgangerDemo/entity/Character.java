package com.facextest.DoppelgangerDemo.entity;

public class Character {

	private Integer characterID;
	private String imgUrl;
	private double contempt;
	private double surprise;
	private double happiness;
	private double neutral;
	private double sadness;
	private double disgust;
	private double anger;
	private double fear;
	// This will be the primary key in relation to the
	// foreign key in the User POJO.
	private double overallScore;

	public Character() {

	}

	public Character(Integer characterID, String imgUrl, double contempt, double surprise, double happiness,
			double neutral, double sadness, double disgust, double anger, double fear, double overallScore) {
		super();
		this.characterID = characterID;
		this.imgUrl = imgUrl;
		this.contempt = contempt;
		this.surprise = surprise;
		this.happiness = happiness;
		this.neutral = neutral;
		this.sadness = sadness;
		this.disgust = disgust;
		this.anger = anger;
		this.fear = fear;
		this.overallScore = overallScore;
	}

	public Integer getCharacterID() {
		return characterID;
	}

	public void setCharacterID(Integer characterID) {
		this.characterID = characterID;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

	public double getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(double overallScore) {
		this.overallScore = overallScore;
	}

	@Override
	public String toString() {
		return "Character [characterID=" + characterID + ", imgUrl=" + imgUrl + ", contempt=" + contempt + ", surprise="
				+ surprise + ", happiness=" + happiness + ", neutral=" + neutral + ", sadness=" + sadness + ", disgust="
				+ disgust + ", anger=" + anger + ", fear=" + fear + ", overallScore=" + overallScore + "]";
	}

}
