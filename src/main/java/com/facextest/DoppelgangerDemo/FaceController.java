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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.facextest.DoppelgangerDemo.entity.Emotion;

@Controller
public class FaceController {

	@Autowired
	Emotion eM;

	@Value("${subscription.key}")
	String subscriptionKey;
	@Value("${uri.base}")
	private static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";

	private static final String imageWithFaces = "{\"url\":\"https://mir-s3-cdn-cf.behance.net/project_modules/1400/a150b671389927.5bc42dc910495.jpg\"}";
	private static final String faceAttributes = "emotion";

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

		return new ModelAndView("results", "results", jsonString);
	}
}