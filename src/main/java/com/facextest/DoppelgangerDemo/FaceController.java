package com.facextest.DoppelgangerDemo;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.facextest.DoppelgangerDemo.entity.FaceWrapper;

@Controller
public class FaceController {

	@Value("${subscription.key}")
	String subscriptionKey;
	@Value("${uri.base}")
	private static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&returnFaceAttributes=emotion";

	private static final String imageWithFaces = "{\"url\":\"https://mir-s3-cdn-cf.behance.net/project_modules/1400/a150b671389927.5bc42dc910495.jpg\"}";

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/getresults")
	public ModelAndView compareFace(@RequestParam("file")String file) throws UnsupportedEncodingException {
		RestTemplate rT = new RestTemplate();

		String imageWithFaces = "{\"url\":\"" + file + "\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Ocp-Apim-Subscription-Key", subscriptionKey);

		HttpEntity<String> entity = new HttpEntity<String>(imageWithFaces, headers);

		FaceWrapper[] response = rT.postForObject(uriBase, entity, FaceWrapper[].class);
		for (int i = 0; i < response.length; ++i) {
			System.out.println(response[i]);
		}

		return new ModelAndView("results", "results", response[0].getFaceAttributes().getEmotion());
	}

	@RequestMapping("/emotionscore")
	public ModelAndView getEmotions() {
		RestTemplate rt = new RestTemplate();

		return new ModelAndView();
	}
}