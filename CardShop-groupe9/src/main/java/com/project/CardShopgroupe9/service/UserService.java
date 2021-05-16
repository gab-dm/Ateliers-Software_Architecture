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
	
	public User getUserByName(String  Name) {
		Optional<User> uOpt =uRepository.findByName(Name);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}
	
	public void UpdateUser (User u ) {
		uRepository.save(u);
	}
	
	//On supprime l'utilisateur depuis son ID.
	public void DeleteUserByID (Integer integer) {
		uRepository.deleteById(integer);
		return ;
		
	}
	//On supprime l'utilisateur depuis son Nom.
		public void DeleteUserByName (String name ) {
			User user =uRepository.findByName(name).get();
			uRepository.deleteById(user.getId());
			return;
			
		}


	
}
