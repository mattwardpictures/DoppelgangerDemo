package com.facextest.DoppelgangerDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceMatcher {

	private String user_id;
	private String user_key;
	private String img_1;
	private String img_2;
	private int face_det;

	public FaceMatcher() {

	}

	public FaceMatcher(String user_id, String user_key, String img_1, String img_2, int face_det) {
		super();
		this.user_id = user_id;
		this.user_key = user_key;
		this.img_1 = img_1;
		this.img_2 = img_2;
		this.face_det = face_det;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_key() {
		return user_key;
	}

	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}

	public String getImg_1() {
		return img_1;
	}

	public void setImg_1(String img_1) {
		this.img_1 = img_1;
	}

	public String getImg_2() {
		return img_2;
	}

	public void setImg_2(String img_2) {
		this.img_2 = img_2;
	}

	public int getFace_det() {
		return face_det;
	}

	public void setFace_det(int face_det) {
		this.face_det = face_det;
	}

	@Override
	public String toString() {
		return "FaceMatcher [user_id=" + user_id + ", user_key=" + user_key + ", img_1=" + img_1 + ", img_2=" + img_2
				+ ", face_det=" + face_det + "]";
	}

}
