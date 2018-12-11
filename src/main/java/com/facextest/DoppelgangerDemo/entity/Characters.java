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
	private String name;

	@Column(name = "picture")
	private String imgUrl;
	private String movie;
	private String personality;

	@OneToMany(mappedBy = "characters", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users = new ArrayList<>();

	public Characters() {

	}

	public Characters(Integer characterID, String name, String imgUrl, String movie, String personality,
			List<User> users) {
		super();
		this.characterID = characterID;
		this.name = name;
		this.imgUrl = imgUrl;
		this.movie = movie;
		this.personality = personality;
		this.users = users;
	}

	public Characters(Integer characterID, String imgUrl, String movie, String personality, List<User> users) {
		super();
		this.characterID = characterID;
		this.imgUrl = imgUrl;
		this.movie = movie;
		this.personality = personality;
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Characters [characterID=" + characterID + ", name=" + name + ", imgUrl=" + imgUrl + ", movie=" + movie
				+ ", personality=" + personality + ", ";
	}

}
