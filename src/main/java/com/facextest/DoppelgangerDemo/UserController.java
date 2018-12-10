package com.facextest.DoppelgangerDemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.facextest.DoppelgangerDemo.Repository.CharacterRepository;
import com.facextest.DoppelgangerDemo.Repository.UserRepository;
import com.facextest.DoppelgangerDemo.entity.User;

@Controller
public class UserController {

	@Autowired
	UserRepository uR;
	
	@Autowired
	CharacterRepository cR;

	@RequestMapping("results")
	public ModelAndView showResultsPage() {
		return new ModelAndView("results");
	}

	@RequestMapping("/addUser")
	public ModelAndView addUser(@RequestParam("username") String name, @RequestParam("file") String imgUrl,
			@RequestParam("score") double overallScore, @RequestParam("score2") Integer characterID,
			RedirectAttributes redirect) {
		User u1 = new User(name, imgUrl, overallScore, characterID);
		uR.save(u1);
		redirect.addFlashAttribute("saved", "Saved succesfully");
		return new ModelAndView("redirect:/topten");

	}
	
	
	@RequestMapping("allusers")
	public ModelAndView showUsers() {
		ModelAndView mv = new ModelAndView("allusers", "model", uR.findAll());
		return mv;
	}

	
	@RequestMapping("legends")
		public ModelAndView showCharacters() {
			
			
			return new ModelAndView("legend", "disney", cR.findAll());
		}
	
}
