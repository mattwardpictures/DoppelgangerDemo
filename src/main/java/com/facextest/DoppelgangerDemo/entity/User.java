package com.facextest.DoppelgangerDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "userid")
	private Integer userID;
	private String name;
	@Column(name = "urlpath")
	private String imgUrl;
	private double contempt;
	private double surprise;
	private double happiness;
	private double neutral;
	private double sadness;
	private double disgust;
	private double anger;
	private double fear;

	// This will be the foreign key...
	// ...in the character POJO it will be the primary key
	@Column(name = "overallscore")
	private double overallScore;

	@ManyToOne
	// corresponds to character id
	@JoinColumn(name = "overallScore", insertable = false, updatable = false)
	private Characters characters;

	public User() {

	}

	public User(Integer userID, String name, String imgUrl, double contempt, double surprise, double happiness,
			double neutral, double sadness, double disgust, double anger, double fear, double overallScore) {
		super();
		this.userID = userID;
		this.name = name;
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

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "User [userID=" + userID + ", name=" + name + ", imgUrl=" + imgUrl + ", contempt=" + contempt
				+ ", surprise=" + surprise + ", happiness=" + happiness + ", neutral=" + neutral + ", sadness="
				+ sadness + ", disgust=" + disgust + ", anger=" + anger + ", fear=" + fear + ", overallScore="
				+ overallScore + "]";
	}

}
