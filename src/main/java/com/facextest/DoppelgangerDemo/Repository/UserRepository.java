package com.facextest.DoppelgangerDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facextest.DoppelgangerDemo.entity.User;

public interface UserRepository extends JpaRepository <User,Integer>{

}
