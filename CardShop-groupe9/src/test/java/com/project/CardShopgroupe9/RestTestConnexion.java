package com.project.CardShopgroupe9;




import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
 
import org.springframework.web.client.RestTemplate;

import com.project.CardShopgroupe9.model.User;
  
public class RestTestConnexion { 

// programme de test inspiré du sring boot rest api exemple du cours que j'ai essyé de modifi pour le projet
	
	
	//encore une métrise très partielle de cette ligne
    public static final String REST_SERVICE_URI = "http://localhost:8081/SpringBootRestApi/api";
      
    /* GET */
    
      
    /* GET */
    private static void getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI+"/user/1", User.class);
        System.out.println(user);
    }
      
    /* POST */
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User("Etiennne", "1234");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/register/", user, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
    
    private static void Connexion() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User("Etienne", "1234");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/login/", user, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
   
  
    /* DELETE */
    private static void deleteUser() {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/3");
    }
  
  
   
    public static void main(String args[]){
        
        //getUser();
        createUser();
        //Connexion();
        //deleteUser();
        
    }
}