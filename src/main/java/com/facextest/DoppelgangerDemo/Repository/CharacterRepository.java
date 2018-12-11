package com.facextest.DoppelgangerDemo.Repository;

import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facextest.DoppelgangerDemo.entity.Characters;

public interface CharacterRepository extends JpaRepository<Characters, Integer> {

	Characters findByName(String characterName);
	
	@Query("select distinct name from Characters")
	TreeSet<String> findDistinctName();

}
