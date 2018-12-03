package com.facextest.DoppelgangerDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceWrapper {

	private FaceAttributes faceAttributes;

	public FaceWrapper() {

	}

	public FaceWrapper(FaceAttributes faceAttributes) {
		super();
		this.faceAttributes = faceAttributes;
	}

	public FaceAttributes getFaceAttributes() {
		return faceAttributes;
	}

	public void setFaceAttributes(FaceAttributes faceAttributes) {
		this.faceAttributes = faceAttributes;
	}

	@Override
	public String toString() {
		return "FaceWrapper [faceAttributes=" + faceAttributes + "]";
	}

}
