package com.facextest.DoppelgangerDemo;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.facextest.DoppelgangerDemo.Repository.CharacterRepository;
import com.facextest.DoppelgangerDemo.entity.FaceWrapper;

@Controller
public class FaceController {

	@Autowired
	CharacterRepository cR;

	@Value("${subscription.key}")
	String subscriptionKey;
	@Value("${uri.base}")
	private static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&returnFaceAttributes=emotion";

	// private static final String imageWithFaces =
	// "{\"url\":\"https://mir-s3-cdn-cf.behance.net/project_modules/1400/a150b671389927.5bc42dc910495.jpg\"}";

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/getresults")
	public ModelAndView compareFace(@RequestParam("file") String file) throws UnsupportedEncodingException {
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

		ModelAndView mv = new ModelAndView("results");

		double score = getScore(response);
		int score2 = (int)Math.round(score);

		mv.addObject("score", getScore(response));
		mv.addObject("results", response[0].getFaceAttributes().getEmotion());
		mv.addObject("ch", cR.findById(score2).orElse(null));

		return mv;

	}

	private static Double getScore(FaceWrapper[] response) {
		Double contempt = (response[0].getFaceAttributes().getEmotion().getContempt());
		Double surprise = (response[0].getFaceAttributes().getEmotion().getSurprise());
		Double happiness = (response[0].getFaceAttributes().getEmotion().getHappiness());
		Double neutral = (response[0].getFaceAttributes().getEmotion().getNeutral());
		Double sadness = (response[0].getFaceAttributes().getEmotion().getSadness());
		Double disgust = (response[0].getFaceAttributes().getEmotion().getDisgust());
		Double anger = (response[0].getFaceAttributes().getEmotion().getAnger());
		Double fear = (response[0].getFaceAttributes().getEmotion().getFear());

		double angerIndex = (contempt + disgust + anger) * 0.05;
		double sadnessIndex = (sadness + fear) * 0.10;
		double neutralIndex = neutral * 0.15;
		double surpriseIndex = surprise * 0.20;
		double happinessIndex = happiness * 0.50;

		double overallScore = (angerIndex + sadnessIndex + neutralIndex + surpriseIndex + happinessIndex) * 100;

		return overallScore;
	}

	@RequestMapping("/lastten")
	public ModelAndView getLastTenResults() {

		return new ModelAndView();
	}
}