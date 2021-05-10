package com.project.CardShopgroupe9.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CardShopgroupe9.model.User;
import com.project.CardShopgroupe9.repository.UserRepository;


import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserService {
	
	@Autowired
	
	UserRepository uRepository;
	
	public void addUser(User u) {
		User createdUser=uRepository.save(u);
		System.out.println(createdUser);
	}
	
	public User getUserById(int id) {
		Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}
	//a retravailler
	public void UpdateUser (User u ) {
		
		
	}
	
	public User DeleteUser (Integer integer) {
		uRepository.deleteById(integer);
		return null;
		
	}
	 /**
     * Methode pour hacher le mot de passe
     */
    public String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    } 



	
}
