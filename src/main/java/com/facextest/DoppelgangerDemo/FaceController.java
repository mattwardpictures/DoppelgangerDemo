package com.facextest.DoppelgangerDemo;

import java.io.UnsupportedEncodingException;
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

	// @RequestMapping("/getresults")
	private double[] getAPIData() {
		response = getFaceMatch(imageUrl);
		Double contempt = (response[0].getFaceAttributes().getEmotion().getContempt());

		Double surprise = (response[0].getFaceAttributes().getEmotion().getSurprise());
		Double happiness = (response[0].getFaceAttributes().getEmotion().getHappiness());
		Double neutral = (response[0].getFaceAttributes().getEmotion().getNeutral());
		Double sadness = (response[0].getFaceAttributes().getEmotion().getSadness());
		Double disgust = (response[0].getFaceAttributes().getEmotion().getDisgust());
		Double anger = (response[0].getFaceAttributes().getEmotion().getAnger());
		Double fear = (response[0].getFaceAttributes().getEmotion().getFear());

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

		mv.addObject("score", score);
		mv.addObject("results", response[0].getFaceAttributes().getEmotion());
		mv.addObject("ch", cR.findById(score2).orElse(null));

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

//	private static Double getScore(FaceWrapper[] response) {
//		Double contempt = (response[0].getFaceAttributes().getEmotion().getContempt());
//		Double surprise = (response[0].getFaceAttributes().getEmotion().getSurprise());
//		Double happiness = (response[0].getFaceAttributes().getEmotion().getHappiness());
//		Double neutral = (response[0].getFaceAttributes().getEmotion().getNeutral());
//		Double sadness = (response[0].getFaceAttributes().getEmotion().getSadness());
//		Double disgust = (response[0].getFaceAttributes().getEmotion().getDisgust());
//		Double anger = (response[0].getFaceAttributes().getEmotion().getAnger());
//		Double fear = (response[0].getFaceAttributes().getEmotion().getFear());
//
//		double angerIndex = (contempt + disgust + anger) * 0.05;
//		double sadnessIndex = (sadness + fear) * 0.10;
//		double neutralIndex = neutral * 0.15;
//		double surpriseIndex = surprise * 0.20;
//		double happinessIndex = happiness * 0.50;
//
//		double overallScore = (angerIndex + sadnessIndex + neutralIndex + surpriseIndex + happinessIndex) * 100;
//
//		return overallScore;
//	}
}