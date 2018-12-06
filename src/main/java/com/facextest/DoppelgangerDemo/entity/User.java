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
	private double overallScore;
	@Column(name = "id")
	private Integer characterID;

	@ManyToOne
	// corresponds to character id
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Characters characters;

	public User() {

	}

	public User(Integer userID, String name, String imgUrl, double overallScore, Integer characterID,
			Characters characters) {
		super();
		this.userID = userID;
		this.name = name;
		this.imgUrl = imgUrl;
		this.overallScore = overallScore;
		this.characterID = characterID;
		this.characters = characters;
	}

	
	
	public User(String name, String imgUrl, double overallScore, Integer characterID) {
		super();
		this.name = name;
		this.imgUrl = imgUrl;
		this.overallScore = overallScore;
		this.characterID = characterID;
	}

	public User(String name, String imgUrl, double overallScore, Integer characterID, Characters characters) {
		super();
		this.name = name;
		this.imgUrl = imgUrl;
		this.overallScore = overallScore;
		this.characterID = characterID;
		this.characters = characters;
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

	public double getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(double overallScore) {
		this.overallScore = overallScore;
	}

	public double getCharacterID() {
		return characterID;
	}

	public void setCharacterID(Integer characterID) {
		this.characterID = characterID;
	}

	public Characters getCharacters() {
		return characters;
	}

	public void setCharacters(Characters characters) {
		this.characters = characters;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", imgUrl=" + imgUrl + ", overallScore=" + overallScore
				+ ", characterID=" + characterID + ", characters=" + characters + "]";
	}

}
