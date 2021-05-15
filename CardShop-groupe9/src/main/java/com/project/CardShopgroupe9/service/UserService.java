package com.project.CardShopgroupe9.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CardShopgroupe9.model.User;
import com.project.CardShopgroupe9.repository.UserRepository;




@Service
public class UserService {
	
	@Autowired
	
	UserRepository uRepository;
	
	public boolean addUser(User u) {
		if(uRepository.findByName(u.getName())==null) {
			User createdUser=uRepository.save(u);
			System.out.println(createdUser);
			return true;
		}
		else {
			return false;
		}
	}
	
	public User getUserById(int id) {
		Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}
	//a retravailler // je ne sais toujours pas vraiment comment faire :/
	public void UpdateUser (User u ) {
		
	}
	
	public User DeleteUser (Integer integer) {
		uRepository.deleteById(integer);
		return null;
		
	}



	
}
