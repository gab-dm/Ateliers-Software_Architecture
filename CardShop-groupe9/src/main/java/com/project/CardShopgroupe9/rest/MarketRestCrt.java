package com.project.CardShopgroupe9.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.CardShopgroupe9.model.Card;
import com.project.CardShopgroupe9.model.Session;
import com.project.CardShopgroupe9.model.User;
import com.project.CardShopgroupe9.repository.CardRepository;
import com.project.CardShopgroupe9.repository.UserRepository;
import com.project.CardShopgroupe9.service.SessionService;
import com.project.CardShopgroupe9.service.UserService;

public class MarketRestCrt {

	UserService uService;
	UserRepository uRepository;
	CardRepository cRepository;
	private SessionService sessionService;
	
	 public static final Logger logger = LoggerFactory.getLogger(UserRestCrt.class);
	
	@RequestMapping(method=RequestMethod.POST,value="/buy")
    public String BuyCard(String token, int cardId,  int sellerId, HttpServletResponse response,HttpServletRequest request) {
       
		User buyer = sessionService.isLogged(token , request);
	 	User seller = uRepository.findById(sellerId).get();
	 	Card card = cRepository.findById(cardId).get();
	 	
	 	
	 	if (buyer.getSolde()<Card.getPrice()) {
			
			logger.error("Pas assez d'argent");
			return "Pas assez d'argent";
		}
		else {
			buyer.setSolde(buyer.getSolde()-Card.getPrice());
			buyer.addCard(card);
			uService.UpdateUser(buyer);
			
			seller.setSolde(seller.getSolde()+Card.getPrice());
			seller.removeCard(card);
			uService.UpdateUser(seller);
			
			return "transaction effectuee";
		} 
    }
	@RequestMapping(method=RequestMethod.POST,value="/sell")
	public String SellCard(String token,  int cardId,  int sellerId, HttpServletResponse response,HttpServletRequest request) {
	       
		 	User seller = uRepository.findById(sellerId).get();
		 	Card card = cRepository.findById(cardId).get();
		 	
		 	if (seller.getSolde()<Card.getPrice()) {
				return "Pas assez d'argent";
				
			}
			else {
				seller.setSolde(seller.getSolde()-Card.getPrice());
				seller.addCard(card);
			} 
	    }
}
