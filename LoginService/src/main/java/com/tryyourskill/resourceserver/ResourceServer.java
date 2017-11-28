package com.tryyourskill.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tryyourskill.model.User;


@SpringBootApplication
@RestController
@EnableResourceServer 
public class ResourceServer {
   public static void main(String[] args) {
      SpringApplication.run(ResourceServer.class, args);
   }

   @RequestMapping(value = "/getUpdatedUser", method = RequestMethod.POST)
   public User login(@RequestBody User user) {
      System.out.println("POST /getUpdatedUser");
	   user.setUsername("Hello "+ user.getUsername()+ " !! ");
	   
	   return user;
   }

 
}
