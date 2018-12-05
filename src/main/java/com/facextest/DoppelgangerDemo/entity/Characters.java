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
	private String movie;

	@OneToMany(mappedBy = "characters", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users = new ArrayList<>();

	public Characters() {

	}

	public Characters(Integer characterID, String imgUrl, String movie, List<User> users) {
		super();
		this.characterID = characterID;
		this.imgUrl = imgUrl;
		this.movie = movie;
		this.users = users;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Characters [characterID=" + characterID + ", imgUrl=" + imgUrl + ", movie=" + movie + ", users=" + users
				+ "]";
	}

}
