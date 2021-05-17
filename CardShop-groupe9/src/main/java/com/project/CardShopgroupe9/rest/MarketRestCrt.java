package com.project.CardShopgroupe9.rest;

import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.CardShopgroupe9.model.Card;
import com.project.CardShopgroupe9.model.Session;
import com.project.CardShopgroupe9.model.User;
import com.project.CardShopgroupe9.model.Market;
import com.project.CardShopgroupe9.repository.CardRepository;
import com.project.CardShopgroupe9.repository.MarketRepository;
import com.project.CardShopgroupe9.repository.UserRepository;
import com.project.CardShopgroupe9.service.MarketService;
import com.project.CardShopgroupe9.service.SessionService;
import com.project.CardShopgroupe9.service.UserService;

public class MarketRestCrt {

	@Autowired
	UserService uService;
	@Autowired
	UserRepository uRepository;
	
	@Autowired
	CardRepository cRepository;
	
	@Autowired
	MarketRepository mRepository;
	
	@Autowired
	MarketService mService;
	
	private SessionService sessionService;
	
	
	 public static final Logger logger = LoggerFactory.getLogger(UserRestCrt.class);
	
	@RequestMapping(method=RequestMethod.POST,value="/buy")
    public String BuyCard(Market market, String token, int cardId,  int sellerId, HttpServletResponse response,HttpServletRequest request) {
       
		User buyer = sessionService.isLogged(token , request);
	 	User seller = uRepository.findById(sellerId)
	 			.orElseThrow(() -> new RuntimeException("Pas d'utilisateur"));
	 	Card card = cRepository.findById(cardId).orElse(new Card());
	 	
	 	return mService.buyACard(buyer, seller, card, market);
	 	
	 	
    }
	@RequestMapping(method=RequestMethod.POST,value="/sell")
	public String SellCard(String token,  int cardId, HttpServletResponse response,HttpServletRequest request) {
	       
		User seller = sessionService.isLogged(token , request);
	 	
	 	Card card = cRepository.findById(cardId).get();
	 	
	 	return mService.sellACard(seller, card);
		
	 	
    }
}
