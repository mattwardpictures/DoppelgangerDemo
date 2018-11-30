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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.facextest.DoppelgangerDemo.entity.FaceMatcher;

@Controller
public class FaceController {

	@Value("${rapidapi.key}")
	String faceKey;

	@RequestMapping("index")
	public ModelAndView compareFace(@RequestParam("user_id") String user_id, @RequestParam("user_key") String user_key,
			@RequestParam("img_1") String img_1, @RequestParam("img_2") String img_2,
			@RequestParam("face_det") int face_det) {

		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-RapidAPI-Key", faceKey);
		headers.add(user_id, "7041acf0f54c5cf35f63");
		headers.add(user_key, "489896a4897f8b99af2c");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		face_det = 1;

		Map<String, String> params = new HashMap<>();
		params.put("img_1",
				"https://66.media.tumblr.com/2af17debcc458e1f77f975035c760de2/tumblr_n7hlzmhKqa1sxrvmko1_1280.jpg");
		params.put("img_2",
				"https://66.media.tumblr.com/81bdaed659fbd2cb32362b766af44e02/tumblr_n5vjnxBU8v1rjw5kqo1_500.png");

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		String url = "https://facex-facex-v1.p.rapidapi.com/compare_faces?bboxes_1=50%2C100%2C150%2C200&bboxes_2=52%2C102%2C150%2C200&face_det="
				+ face_det;

		ResponseEntity<FaceMatcher> response = rt.exchange(url, HttpMethod.POST, entity, FaceMatcher.class, params);

		FaceMatcher faceMatch = response.getBody();

		System.out.println(faceMatch);

		return new ModelAndView("index", "face", faceMatch);

	}

}
