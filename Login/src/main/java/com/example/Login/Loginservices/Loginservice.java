package com.example.Login.Loginservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Login.Logindomain.Login;
import com.example.Login.Loginrepository.*;

@Service
public class Loginservice {
	@Autowired
    private Logininterface repo;
  
	  public Login login(String username, String password) {
	      Login user = repo.findByUsernameAndPassword(username, password);
	      return user;
	  }
}

