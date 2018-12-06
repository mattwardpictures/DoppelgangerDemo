package com.facextest.DoppelgangerDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.facextest.DoppelgangerDemo.Repository.UserRepository;
import com.facextest.DoppelgangerDemo.entity.User;


@Controller
public class UserController {

	@Autowired
	UserRepository uR;
	

	@RequestMapping("/addUser")
	public ModelAndView addUser(@RequestParam("username") String name, @RequestParam("file") String imgUrl, @RequestParam("score") double overallScore, @RequestParam("score2") Integer characterID) {
		User u1 = new User(name,imgUrl,overallScore,characterID);
		uR.save(u1);
		return new ModelAndView("topten");

	}	
	
}
