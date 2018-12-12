package com.facextest.DoppelgangerDemo;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.facextest.DoppelgangerDemo.Repository.UserRepository;
import com.facextest.DoppelgangerDemo.entity.Emotion;
import com.facextest.DoppelgangerDemo.entity.FaceWrapper;
import com.facextest.DoppelgangerDemo.entity.User;

@Controller
public class FaceController {

	@Autowired
	CharacterRepository cR;

	@Autowired
	UserRepository uR;

	@Value("${subscription.key}")
	String subscriptionKey;
	@Value("${uri.base}")
	private static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&returnFaceAttributes=emotion";

	User user;

	FaceWrapper[] response;
	private double[] faceScore;
	private String[] userInput;
	String imageUrl;
	String userName;

	@RequestMapping("/")
	public ModelAndView index() {
		List<User> list = uR.findAll();
		List<User> topTenList = new ArrayList<>();
		for (int i = list.size() - 1; i > list.size() - 11; --i) {
			topTenList.add(list.get(i));
		}

		return new ModelAndView("index", "ten", topTenList);
	}

	@RequestMapping("/aboutus")
	public ModelAndView aboutUs() {
		return new ModelAndView("aboutus");
	}

	@RequestMapping("/aboutproject")
	public ModelAndView aboutProject() {
		return new ModelAndView("aboutproject");
	}

	@RequestMapping("/getresults")
	public ModelAndView compareFace(@RequestParam("username") String name, @RequestParam("file") String imgUrl)
			throws UnsupportedEncodingException {
		imageUrl = imgUrl;
		userName = name;
		response = getFaceMatch(imgUrl);

		ModelAndView mv = new ModelAndView("quiz");

//		double score = getScore(response);
//		int score2 = (int) Math.round(score);
//
//		mv.addObject("score", getScore(response));
//		mv.addObject("results", response[0].getFaceAttributes().getEmotion());
//		mv.addObject("ch", cR.findById(score2).orElse(null));
//
//		mv.addObject("user", name);
//		mv.addObject("url", imgUrl);
//
		return mv;

	}

	private double[] getAPIData() {
		Double contempt = 0.0;
		Double surprise = 0.0;
		Double happiness = 0.0;
		Double neutral = 0.0;
		Double sadness = 0.0;
		Double disgust = 0.0;
		Double anger = 0.0;
		Double fear = 0.0;
		response = getFaceMatch(imageUrl);
		// this is Antonellas fix -- this should not break Matt's logic // but you will
		// need to test
		// validation
		if (response.length == 0) {

			contempt = -0.05;
			surprise = -0.05;
			happiness = -0.09;
			neutral = -0.09;
			sadness = -0.09;
			disgust = -0.09;
			anger = -0.08;
			fear = -0.06;
		} else {

			contempt = (response[0].getFaceAttributes().getEmotion().getContempt());
			surprise = (response[0].getFaceAttributes().getEmotion().getSurprise());
			happiness = (response[0].getFaceAttributes().getEmotion().getHappiness());
			neutral = (response[0].getFaceAttributes().getEmotion().getNeutral());
			sadness = (response[0].getFaceAttributes().getEmotion().getSadness());
			disgust = (response[0].getFaceAttributes().getEmotion().getDisgust());
			anger = (response[0].getFaceAttributes().getEmotion().getAnger());
			fear = (response[0].getFaceAttributes().getEmotion().getFear());
		}
		double angerIndex = (contempt + disgust + anger);
		double sadnessIndex = (sadness + fear);
		double neutralIndex = neutral;
		double surpriseIndex = surprise;
		double happinessIndex = happiness;

		faceScore = getFaceScore(angerIndex, sadnessIndex, neutralIndex, surpriseIndex, happinessIndex);
		System.out.println(Arrays.toString(faceScore));

		return faceScore;
	}

	private double[] getFaceScore(double angerIndex, double sadnessIndex, double neutralIndex, double surpriseIndex,
			double happinessIndex) {
		double[] faceScore = new double[5];
		faceScore[0] = angerIndex;
		faceScore[1] = sadnessIndex;
		faceScore[2] = neutralIndex;
		faceScore[3] = surpriseIndex;
		faceScore[4] = happinessIndex;
		return faceScore;
	}

	// @RequestMapping("/getresults")
	private String[] getUserData() {
		String[] userInput = new String[2];
		userInput[0] = userName;
		userInput[1] = imageUrl;
		return userInput;
	}

	@RequestMapping("/quiz")
	public ModelAndView quiz() {
		return new ModelAndView("quiz");
	}

	@RequestMapping("/quizresult")
	public ModelAndView questionAnswers(@RequestParam("question1") String question1,
			@RequestParam("question2") String question2, @RequestParam("question3") String question3,
			@RequestParam("question4") String question4, @RequestParam("question5") String question5) {

		faceScore = getAPIData();
		if (faceScore.length == 0) {
			faceScore[0] = 0.01;
			faceScore[1] = 0.01;
			faceScore[2] = 0.01;
			faceScore[3] = 0.01;
			faceScore[0] = 0.05;
			// response[0].setFaceAttributes(new FaceAttributes(new
			// Emotion(0.01,.01,.01,.01,.01,.01,.01,.01)));
		}
		double angerChange = faceScore[0];
		double sadnessChange = faceScore[1];
		double neutralChange = faceScore[2];
		double surpriseChange = faceScore[3];
		double happinessChange = faceScore[4];

		// Question 1 conditions
		if (question1.equalsIgnoreCase("happiness")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += 0.1;
		} else if (question1.equalsIgnoreCase("surprise")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += 0.1;
			happinessChange += -0.1;
		} else if (question1.equalsIgnoreCase("neutral")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += 0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		} else if (question1.equalsIgnoreCase("sadness")) {
			angerChange += -0.03;
			sadnessChange += 0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		} else if (question1.equalsIgnoreCase("anger")) {
			angerChange += 0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		}
		// Question 2 conditions
		if (question2.equalsIgnoreCase("happiness")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += 0.1;
		} else if (question2.equalsIgnoreCase("surprise")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += 0.1;
			happinessChange += -0.1;
		} else if (question2.equalsIgnoreCase("neutral")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += 0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		} else if (question2.equalsIgnoreCase("sadness")) {
			angerChange += -0.03;
			sadnessChange += 0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		} else if (question2.equalsIgnoreCase("anger")) {
			angerChange += 0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		}
		// Question 3 conditions
		if (question3.equalsIgnoreCase("happiness")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += 0.1;
		} else if (question3.equalsIgnoreCase("surprise")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += 0.1;
			happinessChange += -0.1;
		} else if (question3.equalsIgnoreCase("neutral")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += 0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		} else if (question3.equalsIgnoreCase("sadness")) {
			angerChange += -0.03;
			sadnessChange += 0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		} else if (question3.equalsIgnoreCase("anger")) {
			angerChange += 0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		}
		// Question 4 conditions
		if (question4.equalsIgnoreCase("happiness")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += 0.1;
		} else if (question4.equalsIgnoreCase("surprise")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += 0.1;
			happinessChange += -0.1;
		} else if (question4.equalsIgnoreCase("neutral")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += 0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		} else if (question4.equalsIgnoreCase("sadness")) {
			angerChange += -0.03;
			sadnessChange += 0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		} else if (question4.equalsIgnoreCase("anger")) {
			angerChange += 0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		}
		// Question 5 conditions
		if (question5.equalsIgnoreCase("happiness")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += 0.1;
		} else if (question5.equalsIgnoreCase("surprise")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += 0.1;
			happinessChange += -0.1;
		} else if (question5.equalsIgnoreCase("neutral")) {
			angerChange += -0.03;
			sadnessChange += -0.05;
			neutralChange += 0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		} else if (question5.equalsIgnoreCase("sadness")) {
			angerChange += -0.03;
			sadnessChange += 0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		} else if (question5.equalsIgnoreCase("anger")) {
			angerChange += 0.03;
			sadnessChange += -0.05;
			neutralChange += -0.1;
			surpriseChange += -0.1;
			happinessChange += -0.1;
		}

		if (angerChange < 0) {
			angerChange = 0.0;
		}

		if (angerChange > 1) {
			angerChange = 1;
		}

		if (sadnessChange < 0) {
			sadnessChange = 0.0;
		}

		if (sadnessChange > 1) {
			sadnessChange = 1;
		}

		if (neutralChange < 0) {
			neutralChange = 0.0;
		}

		if (neutralChange > 1) {
			neutralChange = 1;
		}

		if (surpriseChange < 0) {
			surpriseChange = 0.0;
		}

		if (surpriseChange > 1) {
			surpriseChange = 1;
		}

		if (happinessChange < 0) {
			happinessChange = 0.0;
		}

		if (happinessChange > 1) {
			happinessChange = 1;
		}

		double angerIndex = angerChange * 0.05;
		double sadnessIndex = sadnessChange * 0.10;
		double neutralIndex = neutralChange * 0.15;
		double surpriseIndex = surpriseChange * 0.20;
		double happinessIndex = happinessChange * 0.50;

		double score = (angerIndex + sadnessIndex + neutralIndex + surpriseIndex + happinessIndex) * 100;
		
		ModelAndView mv = new ModelAndView("results");

		int score2 = (int) Math.round(score);
		userInput = getUserData();
		String name = userInput[0];
		String imgUrl = userInput[1];

		response = getFaceMatch(imgUrl);

		mv.addObject("score", score);
		if (response.length == 0) {
			// add extremes here to evaluate to Shrek
			mv.addObject("results", new Emotion(0.01, .01, .01, .01, .01, .01, .01, .01));
			mv.addObject("score", "You messed up!");
		} else {
			mv.addObject("results", response[0].getFaceAttributes().getEmotion());
		}
		// mv.addObject("results", response[0].getFaceAttributes().getEmotion());
		mv.addObject("ch", cR.findById(score2).orElse(null));

		System.out.println("imgUrl:" + imgUrl);

		mv.addObject("user", name);
		mv.addObject("url", imgUrl);

		return mv;
	}

	private FaceWrapper[] getFaceMatch(String imgUrl) {
		RestTemplate rT = new RestTemplate();

		String imageWithFaces = "{\"url\":\"" + imgUrl + "\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Ocp-Apim-Subscription-Key", subscriptionKey);

		HttpEntity<String> entity = new HttpEntity<String>(imageWithFaces, headers);

		FaceWrapper[] response = rT.postForObject(uriBase, entity, FaceWrapper[].class);
		for (int i = 0; i < response.length; ++i) {
			System.out.println(response[i]);
		}
		return response;
	}


}