package com.project.CardShopgroupe9.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.CardShopgroupe9.model.Session;
import com.project.CardShopgroupe9.model.User;
import com.project.CardShopgroupe9.service.SessionService;
import com.project.CardShopgroupe9.service.UserService;
 

@RestController
@RequestMapping("/register")
public class UserRestCrt {
    
    private final UserService uService;
    private final SessionService sessionService;
    
    
    public UserRestCrt(UserService uService, SessionService sessionService) {
    	this.sessionService = sessionService;
    	this.uService = uService;
    }
    
    //piqué sur http://websystique.com/spring-boot/spring-boot-rest-api-example/, pour afficher un message d'erreur
    public static final Logger logger = LoggerFactory.getLogger(UserRestCrt.class);
   
    
    
    
    
    @GetMapping("/test")
    public String test() {
    	return "hello";
    }
    
    
    
    /**
     * requete pour la création d'un nouvel utilisateur
     * 
     * @param user
     * @param response
     */
    
    
    @RequestMapping(method=RequestMethod.POST,value="/register")
    public String addUser(@RequestBody User user, HttpServletResponse response,HttpServletRequest request) {
    	System.out.println(response );
    	System.out.println(request );
        if  ( !uService.addUser(user)) {
        	logger.error("Impossible. Ce nom existe deja ");
        	response.setStatus( HttpServletResponse.SC_BAD_REQUEST);
        	return "erreur";
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
    public void getUser(@RequestBody User user, HttpServletResponse response,HttpServletRequest request) {
        User u = uService.getUserByName(user.getName());
        
        if (u != null && u.getPswd()==user.getPswd()) {
        	
        	Session session = sessionService.setSession(u, request);
        	Cookie token = new Cookie("session", session.getToken()); // on crée un cookie contenant le token de session que l'on va retourner
            token.setPath("/");
            token.setMaxAge(15 * 24 * 60 * 60);// on définit la durée de vie du cookie à 15 jours

            response.setStatus( HttpServletResponse.SC_OK);
            response.addCookie(token); //on ajoute le cookie à la réponse

            return;
        	
        }
        else {
        	logger.error("Mauvais nom ou mot de passe ");
        	response.setStatus( HttpServletResponse.SC_BAD_REQUEST);
            return;
        	
        }
        
        
    }
    
    /**
     * GET
     * Requête de récupération d'un utilisateur en fonction de son id
     * @param idUser
     * @return USer
     */
    @RequestMapping(method=RequestMethod.GET,value="/user/{id}")
    
    public User getUserById(@PathVariable("id") int idUser) {
        User user = uService.getUserById(idUser);
        return user;
    }

    /**
     * GET
     * Requête de récupération d'un utilisateur en fonction de son nom
     * @param nameUser
     * @return USer
     */
    @RequestMapping(method=RequestMethod.GET,value="/user/{name}")
    
    public User getUserById(@PathVariable("name") String nameUser) {
        User user = uService.getUserByName(nameUser);
        return user;
    }
    /**
     * Delete
     * Requête de destruction  d'un utilisateur en fonction de son nom
     * @param idUser
     * @return void
     */
    @RequestMapping(method=RequestMethod.DELETE,value="/user/{name}")
    
    public void DeleteUserById(@PathVariable("name") String nameUser, HttpServletResponse response,HttpServletRequest request) {
        User user = uService.getUserByName(nameUser);
        if (user == null) {
        	logger.error("Utilisateur inconu");
        	response.setStatus( HttpServletResponse.SC_BAD_REQUEST);
            
			
		}
        else {
        	uService.DeleteUserByName(nameUser);
        	response.setStatus( HttpServletResponse.SC_OK);
        }
    }
        
        /**
         * Delete
         * Requête de destruction  d'un utilisateur en fonction de son ID
         * @param idUser
         * @return void
         */
        @RequestMapping(method=RequestMethod.DELETE,value="/user/{id}")
        
        public void DeleteUserById(@PathVariable("id") int idUser, HttpServletResponse response,HttpServletRequest request) {
            User user = uService.getUserById(idUser);
            if (user == null) {
            	logger.error("Utilisateur inconu");
            	response.setStatus( HttpServletResponse.SC_BAD_REQUEST);
                
    			
    		}
            else {
            	uService.DeleteUserByID(idUser);
            	response.setStatus( HttpServletResponse.SC_OK);
            }
		
    }
    
    
  
}
