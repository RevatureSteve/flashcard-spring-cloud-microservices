package com.tryyourskill;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(allowedHeaders="*",allowCredentials="true")
@SpringBootApplication
@RestController

public class AuthenticationServer {
   private static final Log logger = LogFactory.getLog(AuthenticationServer.class);

   public static void main(String[] args) {
      SpringApplication.run(AuthenticationServer.class, args);
   }

   @RequestMapping("/user")
   public Principal user(Principal user) {
      logger.info("AS /user has been called");
      logger.debug("user info: "+user.toString());
      return user;
   }
   /*@RequestMapping(value = "/oauth/token",method = RequestMethod.OPTIONS)
   public HttpServletResponse hello() {
      return new HttpHttpServletResponse.SC_OK;
   }*/
   
}