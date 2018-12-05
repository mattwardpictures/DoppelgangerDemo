package com.facextest.DoppelgangerDemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "characters")
public class Characters {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer characterID;
	@Column(name = "picture")
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
	@Column(name = "overallscore")
	private double overallScore;

	@OneToMany(mappedBy = "characters", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users = new ArrayList<>();

	public Characters() {

	}

	public Characters(Integer characterID, String imgUrl, double contempt, double surprise, double happiness,
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Character [characterID=" + characterID + ", imgUrl=" + imgUrl + ", contempt=" + contempt + ", surprise="
				+ surprise + ", happiness=" + happiness + ", neutral=" + neutral + ", sadness=" + sadness + ", disgust="
				+ disgust + ", anger=" + anger + ", fear=" + fear + ", overallScore=" + overallScore + "]";
	}

}
