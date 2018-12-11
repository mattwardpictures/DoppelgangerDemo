package com.facextest.DoppelgangerDemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.facextest.DoppelgangerDemo.entity.Characters;
import com.facextest.DoppelgangerDemo.entity.User;


public interface CharacterRepository extends JpaRepository<Characters, Integer> {
	

	
	

}
