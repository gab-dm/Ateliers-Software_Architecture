package com.project.CardShopgroupe9.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.CardShopgroupe9.model.Session;
import com.project.CardShopgroupe9.model.User;
import com.project.CardShopgroupe9.service.SessionService;
import com.project.CardShopgroupe9.service.UserService;
 

@RestController
public class UserRestCrt {
    @Autowired
    UserService uService;
    SessionService sessionService;
    
    //piqué sur http://websystique.com/spring-boot/spring-boot-rest-api-example/, pour afficher un message d'erreur
    public static final Logger logger = LoggerFactory.getLogger(UserRestCrt.class);
   
    
    /**
     * requete pour la création d'un nouvel utilisateur
     * 
     * @param user
     * @param response
     */
    @RequestMapping(method=RequestMethod.POST,value="/register")
    public String addUser(@RequestBody User user, HttpServletResponse response,HttpServletRequest request) {
       
        if  ( !uService.addUser(user)) {
        	logger.error("Impossible. Ce nom existe deja ");
        	response.setStatus( HttpServletResponse.SC_BAD_REQUEST);
        	return null;
        }
        else {
        	
			Session session = sessionService.setSession(user, request);
        	response.setStatus( HttpServletResponse.SC_CREATED);
        	return session.getToken(); //jeton de session pour l'utilisateur courant
        }
		
    }
    /**
     * requete pour l'autentification d'un utilisateur
     * @param id
     * @return
     */
    @RequestMapping(method=RequestMethod.POST,value="/login")
    public User getUser(@PathVariable String id) {
        User u = uService.getUserById(Integer.valueOf(id));
        return u;
    }
    
  
}
