package com.project.CardShopgroupe9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CardShopgroupe9.model.Card;
import com.project.CardShopgroupe9.model.Market;
import com.project.CardShopgroupe9.model.User;
import com.project.CardShopgroupe9.repository.MarketRepository;

@Service
public class MarketService {
	
	@Autowired	
	MarketRepository mRepository;
	@Autowired
	UserService uService;
	
	public List<Market> getAllMarket() {
		
		List<Market> MarketList = mRepository.findAll();
		return MarketList;
	}
	
	public String buyACard (User buyer, User seller, Card card, Market market) {
		
		if (buyer.getSolde()<Card.getPrice()) {
					
					
			return "Pas assez d'argent";
		
		}
		else {
			buyer.setSolde(buyer.getSolde()-Card.getPrice());
			buyer.addCard(card);
			uService.UpdateUser(buyer);
			
			seller.setSolde(seller.getSolde()+Card.getPrice());
			seller.removeCard(card);
			uService.UpdateUser(seller);
			
			mRepository.delete(market);
			return "transaction effectuee";
		}
		
	}
	
	public String sellACard(User seller, Card card) {
		
		List<Market> MarketList = this.getAllMarket();
		boolean carteEnVente = false;
		for (Market market : MarketList) {
			
			
			if ((market.getCardId() == card.getId()) && market.getUserId()==seller.getId() ) {
				carteEnVente =true;
			}
		}
		if (!carteEnVente) {
			Market newMarket = new Market(card.getId(), seller.getId());
			mRepository.save(newMarket);
			return "carte mise en vente";
			
			
		}
		else {
			return "la carte est déja en vente";
		}
		
	}
	
}
