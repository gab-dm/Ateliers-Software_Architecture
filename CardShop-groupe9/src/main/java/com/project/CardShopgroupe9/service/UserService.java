package com.project.CardShopgroupe9.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CardShopgroupe9.model.Card;
import com.project.CardShopgroupe9.model.User;
import com.project.CardShopgroupe9.repository.CardRepository;
import com.project.CardShopgroupe9.repository.UserRepository;




@Service
public class UserService {
	
	@Autowired
	
	UserRepository uRepository;
	@Autowired
	CardRepository cRepository;
	
	
	
	public boolean addUser(User u) {
		//System.out.println(uRepository.findByName(u.getName()));
		if(!uRepository.findByName(u.getName()).isPresent()) {
			
			u.setCardList(generateCardList());
			User createdUser=uRepository.save(u);
			System.out.println(createdUser);
			return true;
		}
		else {
			return false;
		}
	}
	public List<Card> generateCardList(){
		Random random = new Random(System.currentTimeMillis()); //Pour avoir une seed "unique", on utilise la date
		
		List<Card> cards = new ArrayList<>();
		List<Card> cardsAvailable = cRepository.findAll();
        int nbCardsAvailable = cardsAvailable.size();
        Card randomCard;
        while(cards.size()<5){
        	
        	int randomNumber =random.nextInt(nbCardsAvailable);
            randomCard = cardsAvailable.get(randomNumber);
            if (randomCard.getIsFree()) {
            	randomCard.setNotFree();
            	cards.add(randomCard);
            	
            }
            
        }
        return cards;
	}
	
	public User getUserById(Integer id) {
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
