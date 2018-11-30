package com.facextest.DoppelgangerDemo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.facextest.DoppelgangerDemo.entity.FaceResult;

@Controller
public class FaceController {

	@Value("${rapidapi.key}")
	String faceKey;

	@RequestMapping("/")
	public ModelAndView compareFace() {

		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-RapidAPI-Key", faceKey);
		headers.add("user_id", "7041acf0f54c5cf35f63");
		headers.add("user_key", "489896a4897f8b99af2c");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);

		Map<String, String> params = new HashMap<>();
		params.put("img_1",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Mohanlal_Viswanathan_Nair_BNC.jpg/240px-Mohanlal_Viswanathan_Nair_BNC.jpg");
		params.put("img_2",
				"https://www.thenewsminute.com/sites/default/files/styles/news_detail/public/Mohanlal_DN_0.jpg?itok=rosZJnyx");

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		String url = "https://facex-facex-v1.p.rapidapi.com/compare_faces?bboxes_1=50%2C100%2C150%2C200&bboxes_2=52%2C102%2C150%2C200&face_det=1";

		ResponseEntity<FaceResult> response = rt.exchange(url, HttpMethod.POST, entity, FaceResult.class, params);

		FaceResult faceMatch = response.getBody();

		System.out.println(faceMatch);

		return new ModelAndView("index", "face", faceMatch);

	}

}
