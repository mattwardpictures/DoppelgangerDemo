package com.facextest.DoppelgangerDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.facextest.DoppelgangerDemo.Repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository uR;
	
	
}
