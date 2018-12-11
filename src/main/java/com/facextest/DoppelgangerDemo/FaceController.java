package com.facextest.DoppelgangerDemo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
		response = getFaceMatch(imgUrl);

		ModelAndView mv = new ModelAndView("results");

		double score = getScore(response);
		int score2 = (int) Math.round(score);

		mv.addObject("score", getScore(response));
		mv.addObject("results", response[0].getFaceAttributes().getEmotion());
		mv.addObject("ch", cR.findById(score2).orElse(null));

		mv.addObject("user", name);
		mv.addObject("url", imgUrl);

		return mv;

	}

//	@RequestMapping("/getresults")
//	private double[] getAPIData(@RequestParam("file") String imgUrl) {
//		response = getFaceMatch(imgUrl);
//		Double contempt = (response[0].getFaceAttributes().getEmotion().getContempt());
//		Double surprise = (response[0].getFaceAttributes().getEmotion().getSurprise());
//		Double happiness = (response[0].getFaceAttributes().getEmotion().getHappiness());
//		Double neutral = (response[0].getFaceAttributes().getEmotion().getNeutral());
//		Double sadness = (response[0].getFaceAttributes().getEmotion().getSadness());
//		Double disgust = (response[0].getFaceAttributes().getEmotion().getDisgust());
//		Double anger = (response[0].getFaceAttributes().getEmotion().getAnger());
//		Double fear = (response[0].getFaceAttributes().getEmotion().getFear());
//
//		double angerIndex = (contempt + disgust + anger);
//		double sadnessIndex = (sadness + fear);
//		double neutralIndex = neutral;
//		double surpriseIndex = surprise;
//		double happinessIndex = happiness;
//		
//		double[] faceScore = new double[5];
//		faceScore[0] = angerIndex;
//		faceScore[1] = sadnessIndex;
//		faceScore[2] = neutralIndex;
//		faceScore[3] = surpriseIndex;
//		faceScore[4] = happinessIndex;
//		
//		return faceScore;
//	}

//	@RequestMapping("/getresults")
//	private String[] getUserData(@RequestParam("username") String name, @RequestParam("file") String imgUrl)
//			throws UnsupportedEncodingException {
//		String[] userInput = new String[2];
//		userInput[0] = name;
//		userInput[1] = imgUrl;
//		return userInput;
//	}
//
//	@RequestMapping("/quiz")
//	public ModelAndView quiz() {
//		return new ModelAndView("quiz");
//	}

//	@RequestMapping("/quizresult")
//	public ModelAndView questionAnswers(@RequestParam("question1") String question1,
//			@RequestParam("question2") String question2, @RequestParam("question3") String question3,
//			@RequestParam("question4") String question4, @RequestParam("question5") String question5) {
//
//		double anger1 = 0.0, anger2 = 0.0, anger3 = 0.0, anger4 = 0.0, anger5 = 0.0;
//		double sadness1 = 0.0, sadness2 = 0.0, sadness3 = 0.0, sadness4 = 0.0, sadness5 = 0.0;
//		double neutral1 = 0.0, neutral2 = 0.0, neutral3 = 0.0, neutral4 = 0.0, neutral5 = 0.0;
//		double surprise1 = 0.0, surprise2 = 0.0, surprise3 = 0.0, surprise4 = 0.0, surprise5 = 0.0;
//		double happiness1 = 0.0, happiness2 = 0.0, happiness3 = 0.0, happiness4 = 0.0, happiness5 = 0.0;
//
//		// Question 1 conditions
//		if (question1.equalsIgnoreCase("happiness")) {
//			anger1 = -0.03;
//			sadness1 = -0.05;
//			neutral1 = -0.1;
//			surprise1 = -0.1;
//			happiness1 = 0.1;
//		} else if (question1.equalsIgnoreCase("surprise")) {
//			anger1 = -0.03;
//			sadness1 = -0.05;
//			neutral1 = -0.1;
//			surprise1 = 0.1;
//			happiness1 = -0.1;
//		} else if (question1.equalsIgnoreCase("neutral")) {
//			anger1 = -0.03;
//			sadness1 = -0.05;
//			neutral1 = 0.1;
//			surprise1 = -0.1;
//			happiness1 = -0.1;
//		} else if (question1.equalsIgnoreCase("sadness")) {
//			anger1 = -0.03;
//			sadness1 = 0.05;
//			neutral1 = -0.1;
//			surprise1 = -0.1;
//			happiness1 = -0.1;
//		} else if (question1.equalsIgnoreCase("anger")) {
//			anger1 = 0.03;
//			sadness1 = -0.05;
//			neutral1 = -0.1;
//			surprise1 = -0.1;
//			happiness1 = -0.1;
//		}
//		// Question 2 conditions
//		if (question2.equalsIgnoreCase("happiness")) {
//			anger2 = -0.03;
//			sadness2 = -0.05;
//			neutral2 = -0.1;
//			surprise2 = -0.1;
//			happiness2 = 0.1;
//		} else if (question2.equalsIgnoreCase("surprise")) {
//			anger2 = -0.03;
//			sadness2 = -0.05;
//			neutral2 = -0.1;
//			surprise2 = 0.1;
//			happiness2 = -0.1;
//		} else if (question2.equalsIgnoreCase("neutral")) {
//			anger2 = -0.03;
//			sadness2 = -0.05;
//			neutral2 = 0.1;
//			surprise2 = -0.1;
//			happiness2 = -0.1;
//		} else if (question2.equalsIgnoreCase("sadness")) {
//			anger2 = -0.03;
//			sadness2 = 0.05;
//			neutral2 = -0.1;
//			surprise2 = -0.1;
//			happiness2 = -0.1;
//		} else if (question2.equalsIgnoreCase("anger")) {
//			anger2 = 0.03;
//			sadness2 = -0.05;
//			neutral2 = -0.1;
//			surprise2 = -0.1;
//			happiness2 = -0.1;
//		}
//		// Question 3 conditions
//		if (question3.equalsIgnoreCase("happiness")) {
//			anger3 = -0.03;
//			sadness3 = -0.05;
//			neutral3 = -0.1;
//			surprise3 = -0.1;
//			happiness3 = 0.1;
//		} else if (question3.equalsIgnoreCase("surprise")) {
//			anger3 = -0.03;
//			sadness3 = -0.05;
//			neutral3 = -0.1;
//			surprise3 = 0.1;
//			happiness3 = -0.1;
//		} else if (question3.equalsIgnoreCase("neutral")) {
//			anger3 = -0.03;
//			sadness3 = -0.05;
//			neutral3 = 0.1;
//			surprise3 = -0.1;
//			happiness3 = -0.1;
//		} else if (question3.equalsIgnoreCase("sadness")) {
//			anger3 = -0.03;
//			sadness3 = 0.05;
//			neutral3 = -0.1;
//			surprise3 = -0.1;
//			happiness3 = -0.1;
//		} else if (question3.equalsIgnoreCase("anger")) {
//			anger3 = 0.03;
//			sadness3 = -0.05;
//			neutral3 = -0.1;
//			surprise3 = -0.1;
//			happiness3 = -0.1;
//		}
//		// Question 4 conditions
//		if (question4.equalsIgnoreCase("happiness")) {
//			anger4 = -0.03;
//			sadness4 = -0.05;
//			neutral4 = -0.1;
//			surprise4 = -0.1;
//			happiness4 = 0.1;
//		} else if (question4.equalsIgnoreCase("surprise")) {
//			anger4 = -0.03;
//			sadness4 = -0.05;
//			neutral4 = -0.1;
//			surprise4 = 0.1;
//			happiness4 = -0.1;
//		} else if (question4.equalsIgnoreCase("neutral")) {
//			anger4 = -0.03;
//			sadness4 = -0.05;
//			neutral4 = 0.1;
//			surprise4 = -0.1;
//			happiness4 = -0.1;
//		} else if (question4.equalsIgnoreCase("sadness")) {
//			anger4 = -0.03;
//			sadness4 = 0.05;
//			neutral4 = -0.1;
//			surprise4 = -0.1;
//			happiness4 = -0.1;
//		} else if (question4.equalsIgnoreCase("anger")) {
//			anger4 = 0.03;
//			sadness4 = -0.05;
//			neutral4 = -0.1;
//			surprise4 = -0.1;
//			happiness4 = -0.1;
//		}
//		// Question 5 conditions
//		if (question5.equalsIgnoreCase("happiness")) {
//			anger5 = -0.03;
//			sadness5 = -0.05;
//			neutral5 = -0.1;
//			surprise5 = -0.1;
//			happiness5 = 0.1;
//		} else if (question5.equalsIgnoreCase("surprise")) {
//			anger5 = -0.03;
//			sadness5 = -0.05;
//			neutral5 = -0.1;
//			surprise5 = 0.1;
//			happiness5 = -0.1;
//		} else if (question5.equalsIgnoreCase("neutral")) {
//			anger5 = -0.03;
//			sadness5 = -0.05;
//			neutral5 = 0.1;
//			surprise5 = -0.1;
//			happiness5 = -0.1;
//		} else if (question5.equalsIgnoreCase("sadness")) {
//			anger5 = -0.03;
//			sadness5 = 0.05;
//			neutral5 = -0.1;
//			surprise5 = -0.1;
//			happiness5 = -0.1;
//		} else if (question5.equalsIgnoreCase("anger")) {
//			anger5 = 0.03;
//			sadness5 = -0.05;
//			neutral5 = -0.1;
//			surprise5 = -0.1;
//			happiness5 = -0.1;
//		}
//
//		double angerChange = anger1 + anger2 + anger3 + anger4 + anger5;
//		double sadnessChange = sadness1 + sadness2 + sadness3 + sadness4 + sadness5;
//		double neutralChange = neutral1 + neutral2 + neutral3 + neutral4 + neutral5;
//		double surpriseChange = surprise1 + surprise2 + surprise3 + surprise4 + surprise5;
//		double happinessChange = happiness1 + happiness2 + happiness3 + happiness4 + happiness5;
//		
////		double[] quizScores = new double[5];
////		quizScores[0] = angerChange;
////		quizScores[1] = sadnessChange;
////		quizScores[2] = neutralChange;
////		quizScores[3] = surpriseChange;
////		quizScores[4] = happinessChange;
//		
//	}

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
}