package com.project.CardShopgroupe9.rest;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/market")
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
	
	@Autowired
	private SessionService sessionService;
	
	
	 public static final Logger logger = LoggerFactory.getLogger(UserRestCrt.class);
	
	@RequestMapping(method=RequestMethod.POST,value="/buy")
    public String BuyCard(Integer marketId, String token, Integer cardId,  Integer sellerId, HttpServletResponse response,HttpServletRequest request) {
       
		User buyer = sessionService.isLogged(token , request);
	 	User seller = uRepository.findById(sellerId)
	 			.orElseThrow(() -> new RuntimeException("Pas d'utilisateur"));
	 	Card card = cRepository.findById(cardId).orElse(new Card());
	 	Market market = mRepository.findById(marketId).orElseThrow(() -> new RuntimeException("Pas de market"));;
	 	System.out.println("this market id is :"+market.getMarketId());
	 	return mService.buyACard(buyer, seller, card, market);
	 	
	 	
    }
	@RequestMapping(method=RequestMethod.POST,value="/sell")
	public String SellCard(String token,  int cardId, HttpServletResponse response,HttpServletRequest request) {
	    System.out.println("token :"+token) ;  
	    
	    System.out.println("cardId :"+cardId) ; 
	    
	    System.out.println("request :"+request) ; 
	    
		User seller = sessionService.isLogged(token , request);
	 	
	 	Card card = cRepository.findById(cardId).get();
	 	
	 	return mService.sellACard(seller, card);
		
	 	
    }
}
