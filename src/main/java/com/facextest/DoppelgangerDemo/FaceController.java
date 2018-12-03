package com.facextest.DoppelgangerDemo;

import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FaceController {

//	@Value("${rapidapi.key}")
//	String faceKey;
	@Value("${subscription.key}")
	String subscriptionKey;
	@Value("${uri.base}")
	private static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";

	private static final String imageWithFaces = "{\"url\":\"https://upload.wikimedia.org/wikipedia/commons/c/c3/RH_Louise_Lillian_Gish.jpg\"}";
	private static final String faceAttributes = "age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise";

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/getresults")
	public ModelAndView compareFace() {
		@SuppressWarnings({ "resource", "deprecation" })
		HttpClient httpclient = new DefaultHttpClient();
		org.apache.http.HttpEntity entity = null;
		String jsonString = null;
		try {
			URIBuilder builder = new URIBuilder(uriBase);

			// Request parameters. All of them are optional.
			builder.setParameter("returnFaceId", "true");
			builder.setParameter("returnFaceLandmarks", "false");
			builder.setParameter("returnFaceAttributes", faceAttributes);

			// Prepare the URI for the REST API call.
			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);

			// Request headers.
			request.setHeader("Content-Type", "application/json");
			request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

			// Request body.
			StringEntity reqEntity = new StringEntity(imageWithFaces);
			request.setEntity(reqEntity);

			// Execute the REST API call and get the response entity.
			HttpResponse response = httpclient.execute(request);
			entity = response.getEntity();
			if (entity != null) {
				// Format and display the JSON response.
				System.out.println("REST Response:\n");

				jsonString = EntityUtils.toString(entity).trim();
				if (jsonString.charAt(0) == '[') {
					JSONArray jsonArray = new JSONArray(jsonString);
					System.out.println(jsonArray.toString(2));
				} else if (jsonString.charAt(0) == '{') {
					JSONObject jsonObject = new JSONObject(jsonString);
					System.out.println(jsonObject.toString(2));
				} else {
					System.out.println(jsonString);
				}
			}
		} catch (Exception e) {
			// Display error message.
			System.out.println(e.getMessage());
		}
//		RestTemplate rt = new RestTemplate();
//		HttpHeaders headers = new HttpHeaders();
//		// headers.add("X-RapidAPI-Key", faceKey);
//		headers.add("Ocp-Apim-Subscription-Key", subscriptionKey);
//		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
//
//		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//		String url = "https://westus.api.cognitive.microsoft.com/emotion/v1.0/recognize";
		return new ModelAndView("results", "results", jsonString);
	}
}